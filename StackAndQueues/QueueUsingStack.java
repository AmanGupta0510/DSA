class MyQueue {

    public void retransfer(){
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    Stack<Integer> st1 ;
    Stack<Integer> st2 ;
    int toppp=-1;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
       
        if(st1.empty()){
            toppp = x;
        }  
        st1.push(x);
    }
    
    public int pop() {
        if(st2.empty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    public int peek() {
        if(st2.empty())return toppp;
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.size() == 0 && st2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
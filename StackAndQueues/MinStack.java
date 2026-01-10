// Question_Name - Min Stack
// Problem_Link  - https://leetcode.com/problems/min-stack/
// PlatForm - LeetCode


package StackAndQueues;
import java.util.Stack;


    
    class MinStack {
    
    Stack<Integer> st; // for normally storing element into the stack. 
    Stack<Integer> monoSt; // for storing non-increasing element from bottom to top.

    public MinStack() {
        st  = new Stack<>();
        monoSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(monoSt.isEmpty())monoSt.push(val);
        else{
            if(monoSt.peek()>=val){ // here, we maintain the non-increasing stack (bottom-up)
                monoSt.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.peek().equals(monoSt.peek())) monoSt.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return monoSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


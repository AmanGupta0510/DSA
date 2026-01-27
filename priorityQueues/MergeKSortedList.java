package priorityQueues;
import java.util.PriorityQueue;

class LinkedList<T>{
    int val;
    LinkedList<T> next;
    public LinkedList(int val,LinkedList<T> next){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    // public LinkedList mergeKLists(LinkedList[] lists) {
        
    //     // simple approach is using min heap
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(LinkedList temp : lists){
    //         while(temp!=null){
    //             pq.add(temp.val);
    //             temp = temp.next;
    //         }
    //     }
    //     LinkedList res = new LinkedList(0);
    //     LinkedList tail = res; 
    //     while(!pq.isEmpty()){
    //         tail.next = new LinkedList(pq.remove());
    //         tail = tail.next;
    //     }
    //     return res.next;
    //     // Here,in this approach Time_Complexity = O(n*logn) and Space = O(n) , n is the number of nodes present out there. 
    // }
    public LinkedList<Integer> mergeKLists(LinkedList<Integer>[] lists) {
        if(lists.length<1)return null; 
        return helper(lists,0,lists.length-1);
    }
    private LinkedList<Integer> helper(LinkedList<Integer>[] lists,int sI,int eI){

        if(sI>=eI)return lists[sI];
        LinkedList<Integer> list1 = helper(lists,sI+1,eI);
        LinkedList<Integer> list2 = lists[sI];
        return merge(list1,list2);
    }
    private LinkedList<Integer> merge(LinkedList<Integer> list1,LinkedList<Integer> list2){
       if(list1==null)return list2;
       if(list2==null)return list1;
       LinkedList<Integer> newH = null;
       LinkedList<Integer> newT = null;
        while(list1!=null && list2!=null){
           
            if(list1.val<list2.val){

                if(newH == null){
                    newH = list1;
                    newT = list1;
                }
                else{
                    newT.next = list1;
                    newT = newT.next;
                }
                list1 = list1.next;
            }
            else{
                if(newH == null){
                    newH = list2;
                    newT = list2;
                }
                else{
                    newT.next = list2;
                    newT = newT.next;
                }
                list2 = list2.next;
            }
        }
        if(list1!=null)newT.next = list1;
        if(list2!=null)newT.next = list2;
        return newH;
    }

}
/**
Explanation:

Approach 1 (Naive):
The first approach is to use min heap add all node val into the heap
after that create a new LinkedList with a dummy value node [0] as head and pull out all the element one by one from the heap and add it to the next of new LinkedList head and so on...

Time_Complexity - O(n*log(n))
Space_complexity - O(logn)

Approach 2 (Better):

Since the node inside the lists are already sorted in the ascending order
so just merge 2 LinkedList into a single sorted LinkedList and so on...
for this start from the last index merge n-1 and n-2 LinkedList first and so on...

Time_Complexity - O(N)
Space_Complexity - O(N) as recursion stack space.

 */

// Question_Name - Kth Largest Element in a stream
// Problem_Link -  https://leetcode.com/problems/kth-largest-element-in-a-stream/
// pLatForm  - LeetCode 

package PriorityQueues;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k ;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i  = 0;i<nums.length;i++){
           while(pq.size() > k-1 && nums[i]>pq.peek())pq.poll(); // here, we r maintaining a k-size max heap in which peek() is the kth largest element.
           if(pq.size()< k) pq.offer(nums[i]);
        }
       
    }
    
    public int add(int val) {
        
        if(pq.size()<k){ // inCase nums.length<k
            pq.offer(val);
        }
        else if(val >= pq.peek()){ // when there is a val > peek() then update the k-size max heap. 
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

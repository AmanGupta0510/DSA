// Question Name - Sliding Window Maximum
// Problem Link - https://leetcode.com/problems/sliding-window-maximum/
// PlatForm - LeetCode


package StackAndQueues;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
   
    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int[] ans = new int[nums.length-k+1];
        int indx = 0;

        for(int j = 0;j<nums.length;j++){
            if(!dq.isEmpty() && dq.peekFirst()<i)dq.pollFirst(); //if the queue contains previous window max element then pop it from front of the queue.
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]){ // while queue contains the smaller element poped it out until we found the max element. 
               dq.pollLast();
            }
            dq.offerLast(j);
            if(j-i+1 == k){
                ans[indx++] = nums[dq.peekFirst()]; //if the window size is k then put the front element in the ans bcz it is the max element of current window.
                i++;
            }
        }
        return ans; 
    }
}
/**
Appraoch 1 (Naive):
The first approach is to generate all subarrays of size k and for each 
k-sized subarray compute the max element.
The above appraoch is somewhere around O(N^2) whcih leads to TLE.

Apprach 2 (Monotonic queue/Deque):
The optimal approach is to use deque to store the max element in such a way that
we don't need to compute max elment for every k-sized subarray everyTime.
we store all the max element in a descending order (Decreasing queue) so if the current window is equla to k
then we get max element at the front of queue.

Time Complexity - O(N)
Space Complexity - O(N)







 */ 
}

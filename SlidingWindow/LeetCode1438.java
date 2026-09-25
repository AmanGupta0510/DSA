// Problem_Name - Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
// Problem_link - https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
// Platform - LeetCode
package SlidingWindow;
import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        ArrayDeque<Integer> min_dq = new ArrayDeque<>();
        ArrayDeque<Integer> max_dq = new ArrayDeque<>();

        int i = 0;
        int ans = Integer.MIN_VALUE;

        for(int j = 0;j<nums.length;j++){

            while(!min_dq.isEmpty() && nums[min_dq.peekLast()] >= nums[j]){
                min_dq.pollLast();
            }
            min_dq.addLast(j);

            while(!max_dq.isEmpty() && nums[max_dq.peekLast()] <= nums[j]){
                max_dq.pollLast();
            }
            max_dq.addLast(j);

            while(i<j && Math.abs(nums[max_dq.peekFirst()] - nums[min_dq.peekFirst()]) > limit){
                i++;
                if(min_dq.peekFirst()<i)min_dq.pollFirst();
                if(max_dq.peekFirst()<i)max_dq.pollFirst();

            }
            ans = Math.max(ans , j-i+1);

        }
        return ans;
    }
}

/**
Intuition is simple
maintain the window having absolute Difference atMost Limit
inOrder to find out the absolute Difference we need min and max element
for that particular window so for that we can use a MONOTONIC QUEUE to hold the max and min element for a windows.

and then just shrink the window when condition get false.



 */

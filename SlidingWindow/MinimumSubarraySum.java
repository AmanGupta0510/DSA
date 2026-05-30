// Question_Name  - Minimum Size Subarray Sum
// Problem_Link -  https://leetcode.com/problems/minimum-size-subarray-sum/
// Platform - LeetCode


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                ans = Math.min(ans,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}

/**
Explanation:
Approach 1:(Sliding window)

1.Calculate the sum of each element and whenver the sum becomes >= target 
then we can assume that the current window between i and j is our possible ans 
and after that start shrinking the window till the sum is not less than target by shifting i to the right and record the min possible window size till the loop runs.

Time_Complexity - O(N)
Space_Complexity - O(1) 



 */
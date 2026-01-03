// Question_Name - Max Consecutive Ones III
// Problem_Link - https://leetcode.com/problems/max-consecutive-ones-iii/description/
// PlatForm - LeetCode


package Arrays.Two_Pointers;
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, flips = k, maxLen = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) flips--;
    
            while(flips < 0) {
               if(nums[left] == 0) flips++;
               left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
         return maxLen;


    }
}
/*
Explanation:-
Approach 1 (Sliding Window):

Mantain a window at most k zeros allowed.
Use two variable i and j to maintain the window
Whenever zeros exceeds k then shrink the window until < k zeroes .

Time Complexity - O(N)
Space Complexity - O(1)


*/
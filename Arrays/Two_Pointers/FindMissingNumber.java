// Question - Find Missing Number
// Problem Link - https://leetcode.com/problems/missing-number/

package Arrays.Two_Pointers;

class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        return ((nums.length*(nums.length+1))/2) - sum;
    }
}
/*
The Appraoch is simple just calculate the sum of all element in the array
and then substract it from the sum of all natural number of N formula.

Time Complexity - > O(n);
Space Complexity - > O(1);



 */

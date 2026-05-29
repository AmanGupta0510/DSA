// Question_Name - Subarray Product Less Than K
// Problem_Link -  https://leetcode.com/problems/subarray-product-less-than-k/
// Platform - LeetCode

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k<=1)return 0;
        int i = 0;
        int product = 1;
        int ans = 0;
        for(int j = 0;j<nums.length;j++){
            product*=nums[j];
            while(product>=k){
                product/=nums[i++];
            }
            ans+=(j-i+1);
        }
        return ans;
    }
}

/**

Explanation:
Approach 1 (Sliding window):

We will use sliding window here to calculate the no.of subarrays product less than K
First we will use two pointers i and j these pointers will make a window where the product is less than k
and we just need to do the summation of the size of valid windows.
we will shrink whenever the window product become larger than K.

Time_Complexity - O(N)
Space_Complexity - O(N)

*/ 
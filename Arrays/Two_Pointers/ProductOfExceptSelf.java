// Question_Name - Product of Array Except Self
// Problem_Link -  https://leetcode.com/problems/product-of-array-except-self/
// PlatForm - LeetCode


package Arrays.Two_Pointers;

public class ProductOfExceptSelf {

class Solution {
    // public int[] productExceptSelf(int[] nums) {
    //     int preffix = 1;
    //     int suffix = 1;
    //     int[] preffixProd = new int[nums.length];
    //     int[] suffixProd = new int[nums.length];
    //     for(int i = 0;i<nums.length;i++){
    //         preffix*=nums[i];
    //         suffix*=nums[nums.length-1-i];
    //         preffixProd[i] = preffix;
    //         suffixProd[nums.length-1-i] = suffix;
    //     }
    //     for(int i = 0;i<nums.length;i++){
    //         int x = i-1<0?1:preffixProd[i-1];
    //         int y = i+1>nums.length-1?1:suffixProd[i+1];
    //         nums[i] = x*y;
    //     }
    //     return nums;
    // }
    public int[] productExceptSelf(int[] nums){
        // first calculate (0->i-1) for every i and add it into res array.
        // then start iterating from last to multiply for every res[i] = res[i]*r; r=preffix product (i+1 -> n-1);   
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1;i<nums.length;i++){
            res[i] = nums[i-1]*res[i-1];
        }
        int r = 1;
        for(int i = nums.length-1;i>=0;i--){
            res[i]*=r;
            r = nums[i]*r;
        }
        return res;

    }
}
}

// Question: - Absolute Difference Between Maximum and Minimum K Elements
// Problem Link - https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements/

package LeetCode_Contest.Weekly_Contest_480;
import java.util.*;
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums); //sort the array so that we can easily pick k smallest ans k largest elements.
        int x = 0;
        int y = 0;
        for(int i = 0;i<k;i++){
            x+=nums[i];
            y+=nums[nums.length-1-i];
        }
       return Math.abs(x-y);
    }
}

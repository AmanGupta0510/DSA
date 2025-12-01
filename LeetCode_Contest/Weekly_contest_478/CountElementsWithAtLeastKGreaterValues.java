// Question - Count Elements With at Least K Greater Values
// Problem Link - https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/
// Platform - LeetCode

package LeetCode_Contest.Weekly_contest_478;
import java.util.*;
class Solution {
    public int countElements(int[] nums, int k) {

        Arrays.sort(nums);//sort the input arrray
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(possible(nums,k,nums[i]))count+=1; // for each number do a binary search to get the count of numbers greater than the current num in logarithmic time.
        }
        return count;
    }

    public boolean possible(int[] nums ,int k,int n){
        int low = 0;
        int high  = nums.length-1;
        while(low<=high){
            int mid = (low+high) / 2;
            if(nums[mid]<=n)low=mid+1;
            else high = mid-1;
        }
        return nums.length - low >= k; // here low is the first index which is greater than n.and we assume that all the elements after low is also strictly greater than n bcz array is sorted. 
    } 
}

/*
Explanation :-
Approach 1 - (Sorting And Binary Search)


Time And Space Complexity:-
Time - O(nlogn) + O(n * logn) ~ O(nlogn) as we sort the array in nlogn time and for each element we do a binary search which takes logn time and we do this for n elements.
space - O(n) 

*/
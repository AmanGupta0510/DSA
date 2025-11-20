// Question - Subsets II
// Problem Link - https://leetcode.com/problems/subsets-ii/
// Platform - LeetCode

package SubsequencesPattern;
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);// we sort the array so that we can easily skip the duplicates and make our result unique without using map or dictionary.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums,0,res,ds);
        return res;
        
    }
    public void helper(int[] nums,int sI,List<List<Integer>> res,List<Integer> ds){
        if(sI>=nums.length){ // baseCase - whenEver sI hit the length of input array just stop the process add the ds into the res and then return to the the previous recursion call Stack.
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[sI]);// pick the current Element.
        helper(nums,sI+1,res,ds);
        ds.remove(ds.size()-1); // not pick the current Element
        while(sI<nums.length-1 && nums[sI]==nums[sI+1])sI++; // this loop just help to skip the duplicates element So, that final result are unique.
        helper(nums,sI+1,res,ds);
    }

    

public static void main(String[] args){
    Solution sol = new Solution();
    int[] nums = {1,2,2};
    List<List<Integer>> res = sol.subsetsWithDup(nums);
    System.out.println(res);
    

}
}

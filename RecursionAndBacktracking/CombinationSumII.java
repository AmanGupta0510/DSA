// Question - Combination Sum II
// Problem Link - https://leetcode.com/problems/combination-sum-ii/
// Platform - LeetCode  

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort the array so that we can avoid the duplicate combination.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates,target,res,temp,0);
        return res;
    }
    public void helper(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int sI){
          
        if(target<=0 || sI>=candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(candidates[sI]);
        helper(candidates,target-candidates[sI],res,temp,sI+1);
        temp.remove(temp.size()-1);
        while(sI<candidates.length-1 && candidates[sI]==candidates[sI+1])sI++; // After execution of 1st funticon call it might be possible that we got our desired combination and if next index is same as current indx then it leads to the duplication of combination so to avoid this we use this loop to skip all the same element.
        helper(candidates,target,res,temp,sI+1);
    }
}
/*
Explanation -

This question is same as Combination Sum problem the entire logic is simillar with only two changes
first in this we can't take same number for unlimited no.of times so for this everytime we recursively call for next Index.
and the array contains duplicate element which leads to duplicate combination so to avoid this we use a loop to skip the same element which make the desired combination.

Time And Space Complexity :-
Time Complexity - O(2^n)
Space Complexity - O(n*k)

 *///thanku



// Question - Combination Sum
// Problem Link - https://leetcode.com/problems/combination-sum/
// Platform - LeetCode

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates,target,0,res,temp); // helper function gives all the possible unique combination of element whose sum equal to target.
        return res;

    }
    public void helper(int[] candidates,int target,int sI,List<List<Integer>> res,List<Integer> temp){

        if(target <= 0 || sI>=candidates.length){ // baseCase- whenever target<=0 or sI>=length of array, we check if target becomes 0 or not if yes then we put temp in the res otherWise return to previous call. 
            if(target == 0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(candidates[sI]); // pick the current element
        helper(candidates,target-candidates[sI],sI,res,temp);// recursively call helper function on the same Index.
        temp.remove(temp.size()-1); // not pick the current element
        helper(candidates,target,sI+1,res,temp); // recursively call helper function for next Index.
    }
}

/* 
Explanation -

Approach 1 (Recursion And BackTracking) -

In this question it asked about the unique combination of candidates where the chosen numbers sum up to Target.
so,for this we need to find all possible combination and check whether the combination is our answer or not,
so, we use recursion and backtracking to generate all possible combination.
 
for each new number, we can either pick it or not pick it.And we can pick the same number for unlimited no.of times. 

1. if pick, just add current number to our combination,So our first fuction call recursively generate combination for the same index till the target becomes 0 or sI>=length of an array.
2. if not pick ,we call the 2nd function recursively for the next index without considering the current indx element.      



Time And Space Complexity:-
Time Complexity - O(2^n * k) 
Space Complexity - O(n*k)
*/

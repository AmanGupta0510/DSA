// Question - Combination Sum III
// Problem Link - https://leetcode.com/problems/combination-sum-iii/
// Platform - LeetCode

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(k,n,res,ds,1);
        return res;

    }
    public void helper(int k,int n,List<List<Integer>> res,List<Integer> ds,int sI){
      
        if(ds.size()>=k || n==0){            
            if(n==0 && ds.size()==k)res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = sI;i<=9; i++){
            ds.add(i);
            helper(k,n-i,res,ds,i+1);           
            ds.remove(ds.size()-1);
        }
    }
}

/*
Explanation :-
Approach 1 - (Recursion And BackTracking)

The Recursive and Backtracking approach is simple just we have to find all the possible combination from 1 to 9 and add those combination
whose sum is equal to n and the size of the array is also equal to k in our result.

Time And Space Complexity - 
Time - O(9!)
Space O(9!) 
 */

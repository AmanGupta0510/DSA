// Question - Palindrome Partitioning
// Problem Link - https://leetcode.com/problems/palindrome-partitioning/

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s,0,res,temp);
        return res;
    }
    public void helper(String s,int sI,List<List<String>> res,List<String> temp){
        if(sI>=s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = sI;i<s.length();i++){
            if(checkPalindrome(s,sI,i)){
                temp.add(s.substring(sI,i+1));
                helper(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean checkPalindrome(String s ,int i ,int j){

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}

/*
Explanation:-
Appraoch 01 (BackTracking) ->

The intuition is simple just find all possible partition and check whether each partition substring are palindrome or not
If a substring is palindrome then we add it to list means we chose this substring and do the same thing for rest so for that we recursively call our helper function.
After one partition we again do same for another possible partition that can be exist in the string and repeat the same process.

Time Complexity -> O(n*n^2)
Space Complexity -> O(n^2)

 */

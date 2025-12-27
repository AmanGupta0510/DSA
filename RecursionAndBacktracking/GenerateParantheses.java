// Question : Generate Parantheses
// Problem link : https://leetcode.com/problems/generate-parentheses/
// Platform : LeetCode
package RecursionAndBacktracking;
import java.util.ArrayList; 
class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        
        ArrayList<String> res = new ArrayList<>();
        String parantheses = "";
        helper(n,res,parantheses,0,0);
        return res;
    }
    public void helper(int n,ArrayList<String> res,String s,int openingB,int closingB){
        // baseCase - when both openingB and closingB reach n then add the string into the result. 
        if(openingB == n && closingB == n){
            res.add(s);
            return;
        }
        // if possible then add "(" in string and call helper for further work.
        if(openingB<n)helper(n,res,s+"(",openingB+1,closingB);
        // if possible means, if closingB is less than the openingB then call helper and in sting add ')'
        // here we compare with openingB bcz a valid parantheses are those who have equal number of closing as well as opening Brackets and after finshing call 1 we can add up only that much closing B which are actually needed. 
        if(closingB<openingB)helper(n,res,s+")",openingB,closingB+1);
        
    }
}
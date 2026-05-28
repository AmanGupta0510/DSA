// Question_Name -  Maximum Nesting Depth of the Parentheses
// Problem_link -   https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// Platform - LeetCode

package String;

public class MaximumNestingDepth {




    public int maxDepth(String s) {
        
        int ans = 0;
        int openingBracketCnt = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            ans = Math.max(ans,openingBracketCnt);
            if(ch=='(')openingBracketCnt++;
            else if(ch==')'){
                openingBracketCnt--;
            }
        }
        return ans;
    }
}
// TimeComplexity - O(N)
// SpaceComplexity - O(1)


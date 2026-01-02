
// Question_Name - Expression Add Operators
// Problem_Link -  https://leetcode.com/problems/expression-add-operators/
// PlatForm - LeetCode 

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> res = new ArrayList<>();
        helper(num,target,"",0,0,res,0);
        return res;
    }
    private void helper(String num,int target,String expression,long val,long prev,List<String> res,int sI){
        // System.out.println(val+" "+expression);
        if(sI>=num.length()){
            if(target==val){
                res.add(expression);
            }
            return;
        }

        for(int i = sI;i<num.length();i++){
            if(i != sI && num.charAt(sI) == '0') break;
            long x = Long.parseLong(num.substring(sI, i + 1));
            if(sI==0){
                helper(num,target,expression+x,x,x,res,i+1);
            }
            else{
                helper(num,target,expression+"+"+x,val+x,x,res,i+1);
                helper(num,target,expression+"-"+x,val-x,-x,res,i+1);
                helper(num,target,expression+"*"+x,((val-prev)+(x*prev)),prev*x,res,i+1);
            }
        }
    }
    
}
/**
**Approach: Backtracking**

Given digits "2-1-1", find all ways to insert `+`, `-`, `*` to get target:
"2*1-1" = 1, "2-1+1" = 2, etc.

**Strategy**: 
For each position between digits, try 3 choices:
1. Multiply current number: 
2. Add next:   
3. Subtract next:

**Helper(index, currentValue, currentExpression)**:
- Base: index == length → check if currentValue == target
- Recursive: try multiply/add/subtract for next digits
- Partition num into numbers eg. "2-11" vs "21-1" using backtracking so that we can use all possibilities.


Time: O(4^N * N) - 4 choices per position × eval time
Space: O(N) recursion stack




 */

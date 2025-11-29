// Question - Letter Combinations of a Phone Number
// Problem Link - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Platform - LeetCode

package SubsequencesPattern;
import java.util.*;
class Solution {
   String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        return helper(digits,0); 

    }
    public List<String> helper(String digits,int sI){
        if(digits.length()-1 == sI ){
          List<String> temp = new ArrayList<>();
          for(int i = 0;i<mapping[digits.charAt(sI)-48].length();i++){
           temp.add(String.valueOf(mapping[digits.charAt(sI) - '0'].charAt(i)));
          }
          return temp;
       }
       
        List<String> temp = helper(digits,sI+1);
        List<String> res = new ArrayList<>();  
        for(int i = 0;i<mapping[digits.charAt(sI)-'0'].length();i++){
            for(int j = 0;j<temp.size();j++){
              res.add(mapping[digits.charAt(sI)-48].charAt(i)+temp.get(j));
            }
        }
        return res;
    }
}

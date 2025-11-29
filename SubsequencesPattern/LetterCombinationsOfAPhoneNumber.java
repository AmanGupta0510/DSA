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

        if(digits.length()-1 == sI ){// base Case - when we reach at the last index of the digits string.we create a list which contains all the character mapped to that digit and return that as list.
        //   List<String> temp = new ArrayList<>();
        //   for(int i = 0;i<mapping[digits.charAt(sI)-48].length();i++){
        //    temp.add(String.valueOf(mapping[digits.charAt(sI) - '0'].charAt(i)));
        //   }
        //   return temp;
        return Arrays.asList(mapping[digits.charAt(sI)-48].split(""));
       }
       
        List<String> temp = helper(digits,sI+1);// recursive function call to get the last index of digits string.
        List<String> res = new ArrayList<>();  
        for(int i = 0;i<mapping[digits.charAt(sI)-'0'].length();i++){
            for(int j = 0;j<temp.size();j++){
              res.add(mapping[digits.charAt(sI)-48].charAt(i)+temp.get(j));
            }
        }// we iterate over the mapped string of current digit and for each character
        //  we iterate over the list returned by the recursive function and combine both the character and add it to the result list and finally return that list. 
       return res;
    }
}
/*
Explantion
Approach 1 - Recursion
I have explained all te steps in the comments of the above code. 

Time And Space Complexity -
Time - O(4^n),n is the length of the digits string as in worst case each digit can map to 4 characters and we have to explore all the combinations.
Space - O(4^n)
*/

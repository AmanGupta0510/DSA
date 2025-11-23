// Question - Minimum String Length After Balanced Removals
// Problem Link - https://leetcode.com/problems/minimum-string-length-after-balanced-removals/
// Platform - LeetCode

package LeetCode_Contest.BiWeekly_contest_169;
import java.util.Stack;
class Solution {
    public int minLengthAfterRemovals(String s) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){             
           if(!st.isEmpty() && ((st.peek()=='a' && s.charAt(i) == 'b') || (st.peek()=='b' && s.charAt(i) == 'a')))st.pop(); //whenEver stack peek element is either 'a' or 'b' and current char is opposite to that we pop the element from stack.
           else{
            st.push(s.charAt(i)); // else we push the char into the stack.
           }
        }
        return st.size(); // finallay return the size of the stack because it stores the unbalanced string length.
    }
}

// In this question a string is given which contains only 'a' and 'b' character and we need to find the minimum possible length of string after removing the balanced strings a string is said to be balanced if the number of 'a' occurence is equal to 'b' occurence in the substring.<br>

// So, the first solution that comes to my mind is that use stack to keep track of previous character and whenever current element is opposite of the peek element of stack we simply pop the peek element form the stack because of them forms the balanced substring and we need to remove them from the string by following this strategy we will be left with the unbalanced string int he stack and finally return the size of the stack.<br>
// <br>
// Time And Space Complexity :- <br>
// Time -> O(n) as we iterate over the full string atleast once.<br>
// Space -> O(n) in worst case stack can store all the characters of the string.

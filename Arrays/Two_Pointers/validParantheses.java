// Question - Valid Parentheses
// Problem Link - https://leetcode.com/problems/valid-parentheses/
// Platform - LeetCode

package Arrays.Two_Pointers;
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(!st.isEmpty() && ((st.peek() == '(' && s.charAt(i) == ')') || (s.charAt(i)==']' && st.peek()=='[') || (s.charAt(i)=='}' && st.peek()=='{'))){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }
}

/*
Explanation - 
A paranthesis is valid if the particular paranthesis is opened and closed
So, for this we will use stack to keep track of prev data
and everyTime when we encounter with a valid paranthesis we remove that particular parantheses from the stack and so on...

At last if our string contains the valid parantheses  then stack become empty if not then stack holds some element,which means string doesnt contains the valid parantheses character.

Time And Spacee Complexity:-
Time - O(N)
Space - O(N)

 */


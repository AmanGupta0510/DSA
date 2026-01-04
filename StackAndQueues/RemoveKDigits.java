// Question_Name - Remove K Digits
// Problem_Link -  https://leetcode.com/problems/remove-k-digits/
// PlatForm - LeetCode

package StackAndQueues;
import java.util.Stack;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            if(st.isEmpty() && num.charAt(i)=='0')continue;//no need to put 0 in the stack when stack is empty,since it causes leading zeros.
            st.push(num.charAt(i));
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }// remove the k elment form the stack.

        String ans = "";
        while(!st.isEmpty()){
            // if(st.size()==1 && ans!="" && st.peek()=='0')break;
            ans = st.pop()+ans;
        }
        return ans==""?"0":ans;

    }
}



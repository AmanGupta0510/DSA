

// Question_Name  -  Evaluate Reverse Polish Notation
// Problem_Link -    https://leetcode.com/problems/evaluate-reverse-polish-notation/
// PlatForm - LeetCode 
package StackAndQueues;
import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> s  = new HashSet<>();
        s.add("+");
        s.add("-");
        s.add("*");
        s.add("/");
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if(!st.isEmpty() && s.contains(tokens[i])){
                int x = st.pop();
                int y = st.pop();
                //  System.out.println(x+" "+y);
                if(tokens[i].equals("+")){

                    st.push(y+x);
                    // System.out.println(st.peek());
                }
                else if(tokens[i].equals("-")){
                    st.push(y-x);
                }
                else if(tokens[i].equals("*")){
                    st.push(y*x);

                }
                else{st.push(y/x);
                }
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}

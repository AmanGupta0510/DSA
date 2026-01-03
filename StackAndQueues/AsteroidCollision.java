// Question_Name - Asteroid Collison
// Problem_link -  https://leetcode.com/problems/asteroid-collision/
// PlatForm - LeetCode
package StackAndQueues;
import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        boolean flag = false;
        for(int i  = asteroids.length-1;i>=0;i--){
            flag = false;
            while(!st.isEmpty() && st.peek()<0 && asteroids[i]>0){
                if(st.peek()*-1 < asteroids[i])st.pop();
                else if(st.peek()*-1 >= asteroids[i]){
                    if(st.peek()*-1 == asteroids[i]){
                        flag = true;
                        st.pop();
                    }
                    else{
                        flag = true;
                    }
                    break;
                }
            }
            if(!flag)st.push(asteroids[i]);
        }
        int[] ans = new int[st.size()];
        int indx = 0; 
        while(!st.isEmpty()){
            ans[indx++] = st.pop();
        }
        return ans; 
    }
}

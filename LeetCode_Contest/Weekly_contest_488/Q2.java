// Question_name - Merge Adjacent Equal Elements
// Problem_Link -  https://leetcode.com/problems/merge-adjacent-equal-elements/
// PlatForm  - LeetCode


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Q2 {




    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            long curr = nums[i];
            while(!st.isEmpty() && curr==st.peek()){ // while curr element == prev(adjacent) till then st.pop()
                st.pop();
                curr*=2; // we are popping adjacent same element so we need to add those adjacent number. 
            }
            st.push(curr);
        }
        List<Long> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        Collections.reverse(res);
        return res;
        
    }
}

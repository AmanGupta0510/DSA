

// Question_Name - Next Greater Element II
// Problem_Link -  https://leetcode.com/problems/next-greater-element-ii/
// PlatForm - LeetCode 
package StackAndQueues;
import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i = 0;i<2*nums.length;i++){
            while(!st.isEmpty() && nums[i%nums.length]>nums[st.peek()]){
                res[st.pop()] = nums[i%nums.length];
            }
            st.push(i%nums.length);
        }
        return res;
    }
}

/*
Explanation
Appraoch 01 (Naive) -
Iterate Whole array for ech element to find the next greater element.
Time Complexity - O(N^2)

Approach 2 (Monotonic Stack) -
What we do that we maintain a stack where it contains all the indices of element which are smaller than the 
current element,
Since we search circularly so for this we can iterate the array twice so that in the first iteration we get the next greater element of a normal array
and in the 2nd iteration we can get the next greater for the circular array.

Time Complexity - O(N)
Space Complexity - O(N)
*/

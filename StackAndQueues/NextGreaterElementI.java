// Question_Name - Next Greater Element
// Problem_Link -  https://leetcode.com/problems/next-greater-element-i/
// PlatForm - LeetCode

package StackAndQueues;
import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        // int[] temp = new int[nums2.length];
        for(int i = nums2.length-1;i>=0;i--){
            while(st.peek()!=-1 && st.peek()<=nums2[i])st.pop();
            if(map.containsKey(nums2[i]))nums1[map.get(nums2[i])] = st.peek();
            st.push(nums2[i]); 
        }
        return nums1;

    }
}

/*
Explanation:
Approach 1(Naive):-

For each element of nums1 search its existence in the nums2 if found then start tracking the next greater elem
after it.But this solution takes O(n^2) time bcz we iterate over nums2 for each element of nums1.

Approach 2 (Monotonic Stack):-
In this approach  we do is first of all mapped the nums1 element with thier respective indexs
after that we start iterating over nums2 from right to left
and for each element  Pop stack while stack.top() ≤ nums2[j] (not greater)
inshort we monotonically maintain the stack so that for any element we got its next greater element without performing redundant iteration.

Time complexity - O(Nums1.length + Nums2.length)
Space complexity - O(N);
 */

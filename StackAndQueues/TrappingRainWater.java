// Question_Name - Trapping Rain Water
// Problem_Link -  https://leetcode.com/problems/trapping-rain-water/
// PlatForm - LeetCode

package StackAndQueues;
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<height.length;i++){
            while(!st.isEmpty() && height[i]>height[st.peek()]){ // we bound two boundaries where water may be trapped
                int elevation = st.pop();
                if(st.isEmpty())break;
                water+=(Math.min(height[i],height[st.peek()])-height[elevation])*(i-st.peek()-1); 
            }
            st.push(i);
        }
        return water;
    }
}
/**
Explanation:-
Approach 1 (MonoTonic Stack):-
This can be solved by maintaining a dec.Stack.
Using Stack we can easily find the left boundaries from where the water start getting trapped
WhenEver current height is > the last seen Index element,so it means probably at the index water get trapped
and by popped out the previous index we get the left boundaries from where water trapped as we maintains a decreasing monptonic stack
then we easily calculate the total water get trapped.

Time Complxity - O(N)+O(N) ~O(2N)
Space Complexity - O(N)


 */

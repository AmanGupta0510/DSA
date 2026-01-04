// Question_Name - Largest Rectangle in Histogram
// Problem_Link  - https://leetcode.com/problems/largest-rectangle-in-histogram/
// PlatForm      - LeetCode

package StackAndQueues;
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
       
        int[] prevS = new int[heights.length];
        int[] nextS = new int[heights.length];
        prevSmallest(heights,prevS);
        nextSmallest(heights,nextS);
        int max = 0;
        for(int i = 0;i<heights.length;i++){
          int height = heights[i];
          int width  = nextS[i]-prevS[i]-1;
          max = Math.max(max,height*width);
        }
        return max;
    }
    public void prevSmallest(int[] heights,int[] prevS){
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i])st.pop();
            if(st.isEmpty())prevS[i] = -1;
            else prevS[i] = st.peek();
            st.push(i); 
        }
    }
    public void nextSmallest(int[] heights,int[] nextS){
        Stack<Integer> st = new Stack<>();
        for(int i = heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            if(st.isEmpty())nextS[i] = heights.length;
            else nextS[i] = st.peek();
            st.push(i); 
        }
    }
}
/*
Explanation:-
Appraoch 1 (Naive):
We need to find the max area of rectangle which can be formed with the help of histogram bar height represented as number in the array,
so my first approach is for every single element find out its smaller to the right,and to the left of current index.
ex:- [2,1,5,6,2,3] -> for 5 ,find its smallest in the right of its index, we got 2 as 1st smaller than 5,in the same way we got 1 as a 1st smaller element of 5 in the left of its index
since we get 1st smaller form both side then we can assume that upto that other index having greater or equal element
so by keeping this in mind we can easily calculate width and same way compute for others.

But...but... it take O(N^2) total time which gives TLE.

Appraoch 2 (Monotonic Stack):
Here we keep the logic same but instead of finding smaller element for each element we find nextS and prevS  in a sigle traverse
by using monotonic stack. 
Initial logic is same but only way of computing prevS and nextS is modified to better versiion which leads to the reduction of time Complexity from O(n^2) to O(n).

Time Complexity - O(3N) ~ O(N)
Space Complexity - O(3N) ~ O(N).

 */

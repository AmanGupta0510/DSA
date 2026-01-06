 // Question_Name - Sum of Subarray Minimums
// Problem_Link -  https://leetcode.com/problems/sum-of-subarray-minimums/
// PlatForm - LeetCode 



package StackAndQueues;

import java.util.Stack;

public class SumOfSubarrayMin {
   
class Solution {
    public int sumSubarrayMins(int[] arr) {
      
      int[] prevS = new int[arr.length];
      int[] nextS = new int[arr.length];
      Stack<Integer> st = new Stack<>();
      for(int i  = 0;i<arr.length;i++){
        while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
            st.pop();
        }
        if(st.isEmpty())prevS[i] = -1;
        else prevS[i] = st.peek();
        st.push(i);
      } 
      while(!st.isEmpty()){
        st.pop();
      }
      for(int i  = arr.length-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
            st.pop();
        }
        if(st.isEmpty())nextS[i] = arr.length;
        else nextS[i] = st.peek();
        st.push(i);
      } 
      long ans = 0;
      for(int i = 0;i<arr.length;i++){
        long temp = (((i-prevS[i]) * (nextS[i]-i)))%1000000007;
        ans = (ans+(arr[i]*temp))%1000000007; 
      }
      return (int)ans;
    }
}

/*
Explanation - 
Approach 1 (Naive Approach):-

The first approach is to generate all the subarrays and then sum all subarray min element present in it,
But this will lead to TLE bcz generating every possible subarray will takes O(n^2) time Complexity,which is not perfect for the given constraints.

Approach 2 (Monotonic Stack):-

The second and optimal approach is to figure out how many times an element can contribute to our ans ,
for that lets take an example - [3,1,2,4] 
here 1 contribution in our ans is 6 how,lets figure it out,
lets consider 1 as a last element and calculate how many subarrays can be made upto 1 as the last element the ans is 2 how just do index+1 and this tells us how many subarrays can be made upto that index.
do same by keeping the 1 as the first element and figure out how many subarrays can be made starting from 1.
Since we need minimum so for that we use PrevS and nextS array to know how many subarrays can be made with the current element.
After that calculate the size (i-prevS[i] * i-nextS[i]) and add the total contribution of an element into the sum.
Example:-[3,1,2,4]
prevS = [-1, 0, 1, 1]  (previous smaller indices)
nextS = [1, 4, 4, 4]   (next smaller indices)

Element 1 (index 1): (1-0) * (4-1) * 1 = 1 * 3 * 1 = 3
Element 2 (index 2): (2-1) * (4-2) * 2 = 1 * 2 * 2 = 4
Element 3 (index 0): (0-(-1)) * (1-0) * 3 = 1 * 1 * 3 = 3  
Element 4 (index 3): (3-1) * (4-3) * 4 = 2 * 1 * 4 = 8
Total = 17 ✓
Time Complexity - O(3N)
Space Complexity - O(N)





 */
}

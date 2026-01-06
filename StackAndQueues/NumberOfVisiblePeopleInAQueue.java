// Question_Name - Number of Visible People in a Queue
// Problem_Link -  https://leetcode.com/problems/number-of-visible-people-in-a-queue/
// PlatForm - LeetCode



package StackAndQueues;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int[] ans = new int[heights.length];
        // Arrays.fill(ans,1);
        ans[heights.length-1] = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = heights.length-1;i>=0;i--){
            int count = 0;
            while(!st.isEmpty() && heights[i]>=st.peek()){ // count all the interger whcih is smller than the curr element
                st.pop();
                count+=1;
            }
            if(!st.isEmpty())count+=1;//we increment count so that we know that upto which index elements are visisble from curr 
            ans[i] = ans[i]+count;
            st.push(heights[i]);
        }
        return ans; 
    }
}

/*
Explanation-:
Approach 1 (Naive):
The naive solution of this problem is to generate all subarrays and increment count for each subarray whcih satisfy the condition of {min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1])}
and put the count at the ith index.
ex:
for(int i = 0;i<n;i++){
    for(int j  = i;j<n;j++){
        if(condition)count+=1;
    }
    ans[i] = count;
} 
the above code has the time complexity of O(n^2),whcih is not optimal for the current constraints.
Time Complexity - O(n^2)
Space Complexity - O(n)

Appraoch 2(Optimal Using Monotonic Stack):

The optimal approach is to start the traversing from the end so that we can easily maintain a stack in whcih
all those elements are present whcih act as an boundary for the current elem and if curr element is greater than the peek() than we popped it out the maintain the count bcz the count gives us the number of element to the right visible to the curr element
at last after coming out of loop we check if there still element are present in the stack that element is the last visible element for the curr element that why we count it too.

Time Complexity - O(N)
Space Complexity - O(N)
 */
}

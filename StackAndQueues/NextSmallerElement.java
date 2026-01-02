

// Question_Name - Next Smaller Element
// Problem_Link -  https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
// PlatForm - GeeksForGeeks 
package StackAndQueues;
import java.util.*;
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
       int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = arr.length-1;i>=0;i-- ){
            while(!st.isEmpty() && st.peek()>=arr[i])st.pop();
            if(st.isEmpty())res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int val : res) result.add(val);
        return result;


    }
}
/*
Explanation
Approach 1 - 

This question is same as next Greater Element I only the logic part use to maintain the stack
monotonically is changed instead of poping out smaller element from stack here we popped out greater elment.

Time Complexity - O(N)
Sapce Complexity - O(N)


*/

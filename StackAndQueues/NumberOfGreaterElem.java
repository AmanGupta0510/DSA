// Question_Name - Number of greater elements to the right
// Problem_Link -  https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1
// PlatForm - GeeksForGeeks
package StackAndQueues;
import java.util.*;
class Solution {
    // public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        // for(int i = 0;i<indices.length;i++){
        //     indices[i] = findAndCount(arr,indices[i]);
        // }
        // return indices;
        
        
        
    // }
    // private static int findAndCount(int[] arr,int indx){
        
    //     int count = 0;
    //     for(int i = indx;i<arr.length;i++){
    //         if(arr[i] == arr[indx])continue;
    //         else if(arr[i]>arr[indx]) count+=1;
    //     }
    //     return count;
    // }
    public static int[] count_NGE(int arr[], int indices[]){
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] Ngearr = new int[arr.length];
        int[] res = new int[indices.length];
        for(int i = arr.length-1;i>=0;i--){
            while(!st2.isEmpty() && arr[i]<st2.peek())st1.push(st2.pop()); // push all greater than current element into stack1
            while(!st1.isEmpty() && st1.peek()<=arr[i])st2.push(st1.pop());// push all smaller than current element into stack2
            if(!st1.isEmpty())Ngearr[i] = st1.size();
            st1.push(arr[i]);
        }
        for(int i = 0;i<indices.length;i++){
            res[i] = Ngearr[indices[i]];
        }
        return res;
        }
    
}

/*
Explanation:-
Appraoch 1 (Naive):
For every element of indexes count all greater element to its right in the arr Array.

Time Complexity - O(N*Q)
Space Complexity - O(Q)

Approach 2 (Stack):
We can use two stack to store all the greater that current element in the stack1 and all smaller than current element in the stack2
Traverse the array from n-1th index and keep all greater element till now seen for current element in the st1
and all smaller element in the st2.

Time Complexity - O(N*Q)
Space Complexity - O(N)
*/

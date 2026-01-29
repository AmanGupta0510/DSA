// Question_Name - Kth Largest Element
// Problem_Link  - https://www.geeksforgeeks.org/problems/kth-largest-element5034/1
// PlatForm      - GeeksForGeeks

package PriorityQueues;
class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        // Your code here
        
        int left = 0;
        int right = arr.length-1;
        
        while(left<=right){
            
            int partitionIndex = partition(arr,left,right);
            
            if(partitionIndex == arr.length-k)return arr[partitionIndex];
            else if(partitionIndex < arr.length-k)left = partitionIndex+1;
            else right = partitionIndex-1;
        }
        return -1;
    }
    private static int partition(int[] arr,int sI,int eI){
        
        int i = sI-1;
        int pivotEle = arr[eI];
        
        for(int j = sI;j<eI;j++){
            if(arr[j]<=pivotEle){
                i+=1;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,eI);
        
        return i+1;
    }
    private static void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
}


/*
Explanation:
Approach 1 (Naive):

Sort the array in non-desending order 
and return the (k-1)th index element.

Time_Complexity - O(N*LOG(N))
Space_Complexity - O(N) sorting space consumption

Approach 2 (Better PriorityQueue):/

Second approach is to use the min heap and in that put first k element of the array and after that 
traverse the rest of the array and whenever current ele > peek() then remove the peek element and so on..
after traversing whole array the peek element is the kth largest element.

Time_Complexity - O(n*log(k))
Space_Complexity - O(k)

Approach 3 (optimal in average and best case scenarios):

Use Quick Select Algo.
just like quick sort but with different approach

1.choose a pivotElemnt (for partition purpose)
2.partition the array into two halves where left side are <= pivitElement and right side are > pivotElement.
3.return the partitionIndex and if it is equal to n-k then return its index element otherwise
 recursively work on either left or right side of partitionIndex.
 
Time_Complexity - O(n) in avg. and best case but in the worst case O(N^2) rarely happens
Space_Complexity - O(1)
 



*/

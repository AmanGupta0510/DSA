// Question_name - Allocate Minimum Pages
// Problem_Link -  https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
// Platform - GeeksForGeeks

package Graph;
class Solution {
    public int findPages(int[] arr, int k) {
    
        if(arr.length < k)return -1;
        
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int i = 0;i<arr.length;i++){
            low = Math.min(low,arr[i]);
            high+=arr[i];
        }
       
        while(low<=high){
            int mid = (low+high)/2;
           
            if(isPossible(arr,mid,k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return low;
        
        
    }
    private boolean isPossible(int[] arr , int mid , int k){
        
        
        int pageCount = 0;
        
        for(int i = 0;i<arr.length;i++){
            
            if(arr[i]>mid)return false;
            pageCount+=arr[i];
            if(pageCount>mid){
                k--;
                
                pageCount=arr[i];
            }
            
        }
        if(pageCount>0)k--;
        return k>=0;
       
    }
}

/*
Explanation:

Approach 1 (Binary Search):

Since we have to allocate pages in such a way that every students receives min one book.
All book must be allocated.
k = no.of students.

Question is asking about the maximum number of pages assigned to any student but we have to return the minimized one.
So we have to find the min among all the possible answer.

1.Apply a binary search on a search space between min(arr) and sum(arr) , find mid.
2.If allocation is possible thn shrink the array from right bcz we need min among max.
3.Otherwise, shrink to left.
4.In the Allocation part , check whether all books are allocated to every students or not using mid(possible ans). 









*/


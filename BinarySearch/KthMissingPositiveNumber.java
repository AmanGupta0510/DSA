// Question Name - Kth Missing Positive Number
// Problem Link -  https://leetcode.com/problems/kth-missing-positive-number/
// Platform - Leetcode


package BinarySearch;

public class KthMissingPositiveNumber {
    



    public int findKthPositive(int[] arr, int k) {
        if(arr[0] > k  )return k;
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] - (mid+1) < k){
                low = mid+1;
            }
            else{
                high = mid-1; 
            }

        } 
       
        return arr[high] + (k-(arr[high]-(high+1)));
    }
}


/**

Explanation:

Appraoch 1:(Binary search)

Since the array is sorted in ascending order,we can count missing number upto ith index using (arr[i] - (i + 1)).
This works because elements should ideally be 1, 2, 3, ..., n in a complete sequence.

1.If missing numbers ≤ k, shrink from the right (eI = mid - 1)
2.If missing numbers > k , shrink from the left (sI = mid+1)
3.Finally return the arr[eI] + x ( x = missing number (k - (arr[eI]-(eI+1))))

Time Complexity - O(logn)
Space Complexity - O(1)

*/
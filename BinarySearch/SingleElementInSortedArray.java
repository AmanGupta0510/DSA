package BinarySearch;

public class SingleElementInSortedArray {
    
    // Question_Name - Single Element in a Sorted Array
// Problem_Link -  https://leetcode.com/problems/single-element-in-a-sorted-array/
// PlatForm - LeetCode



    public int singleNonDuplicate(int[] nums) {
        
        int sI = 0;
        int eI = nums.length-1;

        while(sI<eI){
            int mid = (sI+eI)/2;
            
            if(mid%2==0){
                if(nums[mid]==nums[mid+1])sI=mid+1;
                else eI=mid;
            }
            else{
                if(nums[mid] == nums[mid+1])eI=mid;
                else sI=mid+1;
            }
        }
        return nums[sI];
    }
}
/**
Expanation:
Approach 1 (BinarySearch):
Given array is sorted and consists of only integers where every element appears exactly twice except for one.
So,if the array having all element twice -> [1,1,2,2,3,3,4,4] 
** good Pair = (first occurs on even index and last occurrence on odd index) **
So, we will use this property to identify where the single element lie

1. if mid is even and mid+1 and mid element produce good pair then sI=mid+1.
     otherwise eI=mid,missing element in the left part.
2. if mid is odd and mid+1 and mid element produce good pair then eI = mid.
     otherwise sI = mid+1,missing element in the right part.     

Time_Complexity - O(logN)
Space_Complexity - O(1)

 */


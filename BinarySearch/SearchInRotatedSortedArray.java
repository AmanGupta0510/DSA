// Question_Name - Search in Rotated Sorted Array
// Problem_Link -  https://leetcode.com/problems/search-in-rotated-sorted-array/
// PlatForm - LeetCode 

package BinarySearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        
        int sI = 0;
        int eI = nums.length-1;

        while(sI<=eI){
            int mid = (sI+eI)/2;
            if(nums[mid] == target)return mid;
            else{
                if(nums[sI]<=nums[mid]){  
                    if(target>=nums[sI] && target<nums[mid])eI = mid-1;// target  in the sorted part. 
                    else sI=mid+1; // target not in the sorted part. 
                }
                else{
                    if(target>=nums[mid] && target<=nums[eI])sI=mid+1; // target  in the sorted part. 
                    else eI = mid-1;// target not in the sorted part. 
                }
            }
        }
        return -1;

    }
}
/**
Explanation :
Approach 1 (BinarySearch):

1. Apply a binary search in th array.
2. check if the mid element is the target if yes then straight away return the mid.
3. if not then try to figure out which part is sorted [sI...mid] or [mid...eI]
   after figuirng out the sorted part figure out  the part where our ans can be found.
   check if our target can be found in the sorted part if yes then shrik the array
   if our taarget not there in the sorted part then shrik the array to the unsorted part and try to search there.   

4.return -1 if fail to find the target.

Time_Complexity - O(logN)
Space_Complexity - O(1)
 */


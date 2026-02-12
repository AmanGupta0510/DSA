// Question_Name -  Search in Rotated Sorted Array II
// Prolem_Link -    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// PlatForm - LeetCode

package BinarySearch;

public class SearchInRotatedSortedArrayII {




    public boolean search(int[] nums, int target) {
        
        int sI = 0;
        int eI = nums.length-1;

        while(sI<=eI){
            int mid = (sI+eI)/2;
            // System.out.println(sI+" "+eI);
            if(nums[mid] == target)return true;
            if(nums[sI]==nums[mid] && nums[mid]==nums[eI]){ // if duplicates are the then try to find the  sorted rotated  part by shrinking the array form right.
                eI--;
            }
            else if(nums[sI]<=nums[mid]){
                if(nums[sI]<=target && target<nums[mid])eI=mid-1;
                else sI=mid+1;
            }
            else{
                if(nums[mid]<target && target<=nums[eI])sI=mid+1;
                else eI = mid-1;
            }
        }
        return false;
    }
}


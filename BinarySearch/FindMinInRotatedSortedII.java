
// Question_Name - Find Minimum in Rotated Sorted Array II
// Problem_Link  - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// PlatForm - LeetCode
package BinarySearch;

public class FindMinInRotatedSortedII {



    public int findMin(int[] nums) {
        
        int sI = 0;
        int eI = nums.length-1;

        while(sI<eI){

            int mid = (eI+sI)/2;
            if(nums[sI]==nums[mid] && nums[mid]==nums[eI])eI--;
            else if(nums[mid]>nums[eI]){
                sI = mid+1;
            }
            else eI = mid;

        }
        return nums[sI];

    }
}
/*

Explanation:
Appproach 1 (BinarySearch):

Since the array is sorted and rotated so the minimum element is the 0th element of sorted part of array.

1. if nums[mid]==nums[sI] and nums[mid]==nums[eI] it means that from [mid...eI] the array is not sortted and rotated so to maintain it property we start shrinking array from right until we dont get a valid sorted and rotated part .

2. if nums[mid]>nums[eI] -> pivot point sI=mid+1 becoz [mid...eI] is the sorted part we are looking for.
3. nums[mid]<=nums[eI] -> left part sorted , eI=mid.

Time_Complexity - O(logN)
Space_Complexity - O(1)


*/


// Question_Name -  Find Minimum in Rotated Sorted Array
// Problem_Link -   https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// PlatForm - LeetCode

package BinarySearch;

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {

        int sI = 0;
        int eI = nums.length - 1;

        while (sI < eI) {
            int mid = (sI + eI) / 2;
            if (nums[mid] > nums[eI])
                sI = mid + 1;
            else
                eI = mid;
        }
        return nums[sI];
    }
}
/**
 * Explanation:
 * Approach 1 (binary serach)
 * Since the array is sorted and rotated at some k .
 * 
 * Binary search on rotated array:
 * - nums[mid] > nums[end] → pivot (min) in RIGHT → sI = mid+1
 * - nums[mid] ≤ nums[end] → LEFT half sorted → eI = mid
 * 
 * Time_Complexity - O(logn)
 * Space_Complexity - O(1)
 * 
 */

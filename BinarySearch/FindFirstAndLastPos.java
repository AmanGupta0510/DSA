// Question_Name -  Find First and Last Position of Element in Sorted Array
// Problem_Link -   https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// platForm - LeetCode

package BinarySearch;

public class FindFirstAndLastPos {

    public int[] searchRange(int[] nums, int target) {
        
        int i = 0;
        int j = nums.length-1;
        int[] ans  = new int[]{-1,-1};
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
               ans[0] = binarySearch(nums,i,mid,target,true); // search first index between i to mid. 
               ans[1] = binarySearch(nums,mid,j,target,false); // search last index between mid to j.
               return ans;   
            }
            else if (nums[mid]>target){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
    
    private int binarySearch(int[] nums, int sI,int eI,int target, boolean left){
        int ans = -1;
        while(sI<=eI){
            int mid = (sI+eI)/2;
            if(nums[mid]==target){
                ans = mid;
                if(left)eI=mid-1;
                else sI=mid+1;
            }
            else if(nums[mid]>target)eI=mid-1;
            else sI=mid+1;
        }
        return ans;
    }
}


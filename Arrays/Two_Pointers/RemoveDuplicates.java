package Arrays.Two_Pointers;

/*
Question_Name - Remove Duplicates from Sorted Array
Problem_Link -  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
PaltForm - LeetCode
*/

class Solution {
    
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[i]!=nums[j])nums[++i] = nums[j];
        } 
        return i+1;
    }
}
/*
Explanation - 
Approach 01 ->

The first approach comes to my mind is that since the array is sorted in ascending order so if an element has its duplicates then
it appears in a sequence eg.[1,1,1,2,3,3],here 1 has duplicates so it is appear in a sequence so we can use this property to remove 
all the duplicates.
So, we can use two pointer approach , in which we can keep a i variable at the 0th indx and j also at the 0th indx
we move jth indx by one sequencially but whenever jth element != ith element then we move ith indx by one and put the jth indx
value to ith indx, in this way we can remove all the duplicates and till i+1th indx we get all the unique element.

Time Complexity - O(N)
Space Complexity - O(1)


 */

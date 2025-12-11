// Question - Check if Arrays is Sorted and Rotated
// Problem Link - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
package Arrays.Two_Pointers;
class Solution {
    public boolean check(int[] nums) {       
       
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i] > nums[(i+1)%nums.length]){
                count+=1;
            }
        }
        return count<=1;
    }
}

// Intuition
/*
The question is asking about the array is sorted and rotated or not.
If an array is sorted and rotated then at one point it start decreasing Example: [1,2,3,4,5] -> sorted Array 
[4,5,1,2,3]-> rotated right by 2.
here at index 2 element start decreasing which shows that the array is sorted and rotated but only if there is only one index in whole Array
where the elemnt is decreasing if there or more than 1 point then the array is rotated but not sorted.

Approach 1 (Linear Traversal)- 

Initialize a varibale count and keep it increasing whenever a point is found where the next right elment is smaller than the current element
after traversing the array if the count is 1 or 0 then return true as the array is sorted and rotated.
 
Time Complexity - O(N)
Space Complexity - O(1)  



 */
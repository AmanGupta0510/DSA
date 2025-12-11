// Question - Move Zeroes
// Problem Link - https://leetcode.com/problems/move-zeroes/


package Arrays.Two_Pointers;

class Solution {
    public void moveZeroes(int[] nums) {
        
        int i = 0;
        for (int j = 1;j<nums.length;j++){
            if(nums[i] == 0 && nums[j] != 0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            else if(nums[i]!=0){
                i++;
            }
        }
    }
}

/*
Appraoch 1 -:
We will use two pointer approach to solve this problem without using any extra space
we do it in-place.

if the ith elemnet is 0 and jth is non-zero then we swap the elements
and increse the ith index by one and we do this whenever the condition satisfy.

but when the ith element is non-zero then we need to increment i so for this we use another condition that whenver ith index element is non-zero then increment i by 1.

Time Complexity - > O(n)
Space Complexity - > O(1)


*/

// Question - Rotate Array
// Problem Link - https://leetcode.com/problems/rotate-array/
package Arrays.Two_Pointers;

class Solution {
    //  public void rotate(int[] nums, int k){
    //   int[] ans = new int[nums.length];
    //   int x = 0;
    //   for(int i = (nums.length-k)%nums.length;i<nums.length;i++){
    //       ans[x++] = nums[i];
    //   }
    //   for(int i = 0;i<(nums.length-k)%nums.length;i++){
    //       ans[x++] = nums[i];
    //   }
    //   for(int i = 0;i<nums.length;i++){
    //       nums[i] = ans[i];
    //   }

    //  }

    public void rotate(int[] nums, int k) {        
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int i ,int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
/*
Appraoch 1 (Naive Approach):-
Use an extra Array to store the rotated array.

first start from (nums.length-k)th index and go till the last.
 input array        rotated array
[1,2,3,4,5,6,7] -> [5,6,7,0,0,0,0]

Then, start from 0th index and go till (nums.length-k-1)th index.
 input array        rotated array
[1,2,3,4,5,6,7] -> [5,6,7,1,2,3,4]

final result    -> [5,6,7,1,2,3,4] 
        
Time Complexity -> O(n)
Space Complexity -> O(n) as we use another array to store our result.


Apprach 2 (Better Than Naive) :->

First of all reverse full array
[1,2,3,4,5,6,7] - > [7,6,5,4,3,2,1]
Then, reverse first k part means from (0 to k-1).
[7,6,5,4,3,2,1] - > [5,6,7,4,3,2,1]
Then, reverse rest part of the array (k to n-1).
[5,6,7,4,3,2,1] - > [5,6,7,1,2,3,4] 

final result - > [5,6,7,1,2,3,4].

Time Complexity - > O(n)
Space Complexity - > O(1) as we dont use any extra space , we do in-place. 

 */

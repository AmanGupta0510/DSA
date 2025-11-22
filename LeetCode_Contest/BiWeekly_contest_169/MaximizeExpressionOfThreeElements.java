// Question - Maximize Expression of Three Elements
// Problem Link - https://leetcode.com/problems/maximize-expression-of-three-elements/
// Platform - LeetCode

package LeetCode_Contest;

class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int frstLargest = -100;
        int scndLargest = frstLargest;
        int mini = 100;
        for(int i = 0;i<nums.length;i++){
           if(nums[i]>=frstLargest){
               scndLargest = frstLargest;
               frstLargest =  nums[i];
           }
            else if(nums[i]>scndLargest && nums[i]!=frstLargest){
                scndLargest = nums[i];
            }
            mini = Math.min(mini,nums[i]);
            
        }
        return frstLargest+scndLargest-mini;
    }
}

// Actually this question is really a straight forward question.<br>
// In this question we need to choose three elements i,j,k from the input array such that the value of the expression i+j-k is maximized.<br>

// Appraoch 1 :-<br>
// The first solution comes to my mind is to get the maximum , second maximum and minimum element from the array because question is about the maximum possible value so if we add the max and second max and substract the minimum value then we get the maximum possible value.<br>
// <br>
// Example :-<br>
// [1,4,2,5]
// if we take out the maximum and second maximum and add both of them and we get the maximum possible (5+4 = 9) value present in the current array and we need to substract also as per the expression so it is best to substract the minimum element of the array so that we get the maximum possible value after computing according to the expression.

// <br>
// Time And Space Complexity :- <br>
// Time -> O(n) as we iterate over the full array atleast once.
// <br>
// Space -> O(1) we don't use any extra space to store our answer. 


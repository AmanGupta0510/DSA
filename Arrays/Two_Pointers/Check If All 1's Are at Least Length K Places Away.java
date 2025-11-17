// Question - Check If All 1's Are at Least Length K Places Away
// Problem Link - https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/ 
// Platform - LeetCode
package Arrays.Two_Pointers;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j] == 1 && i!=j){
                if(nums[i]==1 && j-i-1 < k)return false; 
                i = j;
            }
        }
        return true;
       
    }
}
// Explanation :-
//  This question is the perfect example of two pointer pattern where we need to maintain k distance between two 1's 
//  in the array. 
// So, we have to traverse the array and whenever we get 1 at an index then first we have to check whether this index is not same as ith index
// ith index is used to keep track of previous 1's index. If both indexes are not same.
// Then we have to check whether the distance between these two are atLeast k or not if not then straight away return false otherwise if whole array traversed then return true by keeping the assumption that all 1's are at least k places away from each other.

// Time And Space Complexity :-
// Time -> O(n) as we traverse the whole array once.
// Space -> O(1) as we are using constant space.
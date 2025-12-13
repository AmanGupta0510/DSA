// Question - Sort Colors
// Problem Link - https://leetcode.com/problems/sort-colors/

package Arrays.Two_Pointers;
class Solution {
    public void sortColors(int[] nums) {
        
        int i = 0;
        int two = nums.length-1;
        int zero = 0;
        // while(i<=j){
        //     if(nums[i] == 2){
        //         nums[i] = nums[j];
        //         nums[j] = 2;
        //         j--;
        //     }
        //     else if(nums[i] == 0){
        //        nums[i] = nums[k];
        //        nums[k] = 0;
        //        k+=1;
        //        i+=1;
        //     }
        //     else i+=1;
        // }
        
        for( i = 0;i<=two;i++){
            if(nums[i] == 2){
                nums[i] = nums[two];
                nums[two] = 2;
                two-=1;
                i-=1;
            }
            else if(nums[i]==0){
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero+=1;
            }
        }
    }
}

/*
Explanation:-
Approach 1 (Naive Solution):-

In first traversal just take three variable zero,one,two and increment as required.
and in second traversal replace the current element of array with zero first,then with one and then with two.

Time Complexity -> O(n)+O(n) ~ O(n)
Space Complexity -> O(1)

As the question asked to do in the single pass so for this we'll use Two pointer Approach,
Approach 2 (Two Pointer):-
Initialize two variable which place the 0's and 2's on its right position
and if current element is either 0 or 2 then place it in its right position with the help of variable/pointers.
and if we successfully place 0 and 2 in its right position then automatically 1 comes to its right position.

Time Complexity -> O(n)
Space Complexity -> O(1)

*/


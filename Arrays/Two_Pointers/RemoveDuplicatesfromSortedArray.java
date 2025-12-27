package Arrays.Two_Pointers;

class Solution {
    public int removeDuplicates(int[] nums) {
        

        int i = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i+=1;
            }
        }     
        return i+1;
    }
}

/*
Intuition:-
Just keep all unique elements in the first k part of the array.

Approach 1 (Two Pointers) :-

This can be easily solve using two Pointer approach just place the ith variable at the 0th index
and jth variable for normal traversal
so whenever we got distinct element we move our i to next index and put the jth element bcz array is sorted 

[1,1,1,2,2,3,3]
 0 1 2 3 4 5 6

 let i be on the 0th index j on the 0th index
 when j is on the 3rd index the ith element is not equal to jth element
 so we put jth index element to (i+1)th index of an array and so on...

 Following this we can easily remove duplicates in_place without using an extra Space.

 Time Complexity - O(n)
 Space Complexity - O(1).
 




 */

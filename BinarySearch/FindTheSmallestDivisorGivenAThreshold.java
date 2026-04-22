// Question Name - Find the Smallest Divisor Given a Threshold
// Problem Link -  https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
// Platform - LeetCode

package BinarySearch;

public class FindTheSmallestDivisorGivenAThreshold {
    




    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i= 0;i<nums.length;i++){
            high  = Math.max(high,nums[i]);
        } 

        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums,mid,threshold)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low; 

    }
    private boolean isPossible(int[] nums, int k,int threshold){

        int sum = 0;
        for(int i = 0;i<nums.length;i++){
           
           sum+=(nums[i]+k-1)/k;
        }
        return sum<=threshold;



    }
}

/**
Explanation

Approach 1 (Binar search):

Intuition behind this problem is simple , I have to find the  smallest divisor such that after dividing the arrays element sum should be less than or equal to threshold.

1. Set the the search space between 1 to max(element in the array).
2. Apply the binary search and try to shrink the search space by checking whether the possible answer lie ont he left or right halves.
3. For every mid check whether the (ceil division) divisor sum up to <= threshold.

Time Complexity - O(n log n),log n for bs and n bcz for every mid we are traversing the whole array. 
Space Complexity - O(1)





 */ 


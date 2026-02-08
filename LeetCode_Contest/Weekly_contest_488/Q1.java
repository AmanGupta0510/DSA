// Question_Name  - Count Dominant Indices
// Problem_Link  -  https://leetcode.com/problems/count-dominant-indices/
// PlatForm - LeetCode

public class Q1 {
    public int dominantIndices(int[] nums) {

        int dominontCount = 0;

        // for(int  i = 0;i<nums.length-1;i++){
        //     int sum = 0;
        //     for(int j = i+1;j<nums.length;j++){
        //         sum+=nums[j];
        //     }
        //     if(nums[i] > sum/(nums.length-1-i)){
        //         dominontCount+=1;
        //     }
        // }
        int preffixSum = 0;
        for(int i:nums){
            preffixSum+=i;
        } 
        for(int i = 0;i<nums.length-1;i++){
            preffixSum-=nums[i];
            if(preffixSum/(nums.length-i-1) < nums[i])dominontCount+=1;
        }
        return dominontCount;
    }
}

/**
Explanation:
Approach 1 (Naive):

1. For every i calculate Sum(i+1 .... n-1)elements
2. Checks if the Avg(sum) < ith element.
3. Repeat for every ith element in the array. 
Time_Complexity - O(n^2)
Space_Complexity - O(1)

Approach 2 (Better in terms of Time):
1. First of all calculate the prefix sum.
2. For every iteration in the array decrease the preffix sum with the sum of all element visited till now,
   [5,4,3] -> preffix sum = 12
   for 0th index prefix sum become 12-5 = 7 and then increment dominantCount if Avg(7)<nums[i]
   for 1th index prefix sum becomes 7-4 = 3 and do the same.
3. By this approach we can decrese the time form n^2 to n.

Time_Complexity - O(n)
Space_Complexity - O(1)


*/
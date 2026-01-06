// Question_Name - Subarray Sum Equals K
// Problem_Link -  https://leetcode.com/problems/subarray-sum-equals-k/
// PlatForm - LeetCode


package HasMapAndPrefixSum;

import java.util.HashMap;

public class SubarrayWithSumK {



class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i  = 0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
               count+=map.get(sum-k);
            }
            if(!map.containsKey(sum)){
                map.put(sum,1);
            }
            else{
                map.put(sum,map.get(sum)+1); //if sum already present in the map then increment its frequency this tells from i to j we have same sum as computed already... 
            }

        }
        return count;
    }
}
/*
Explanation:-
Appraoch 1 (Naive):
The first Approach is to generate every Possible subarray and compute it sum and if their sum is equal to k
then increment count.
The the problem in this solution is the Time it takes it take around O(N^2) which leads to TLE

Appraoch 2 (PrefixSum + HashMap):
The second and optimal appraoch is to use hashmap to keep track of all the preffix sum
of the array and whenever at any point if sum-k is already availiable in the map then simply add its count to the ans this helps to avoid redundant computation of sum again and again...

Time Complexity - O(N)
Space Complexity - O(N)




 */
}

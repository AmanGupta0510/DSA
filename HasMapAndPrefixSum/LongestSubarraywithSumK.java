// Question_Name - Longest Subarray with Sum K
// Problem_Link  - https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
// PlatForm - LeetCode

import java.util.HashMap;

public class LongestSubarraywithSumK {


// User function Template for Java


    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                ans = Math.max(ans,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){ // becoz i want max len so i dont wnat to update my map if same sum is appears again.if current sum is already present in map it means current sum already evaluates before and i need longest so,from prev index to curr index is my longest subarray whose sum is already there in the map.     
                map.put(sum,i);
            }
        }
        return ans;
        
    }
}



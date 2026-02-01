// Question_Name - Minimum K to Reduce Array Within Limit
// Problem_Link - https://leetcode.com/contest/biweekly-contest-175/problems/minimum-k-to-reduce-array-within-limit/ 
// PlatForm - LeetCode
package LeetCode_Contest.Biweekly_contest_175;
class Solution {
    public int minimumK(int[] nums) {

        long sI = Integer.MAX_VALUE;
        long eI = 0;
        for(int i = 0;i<nums.length;i++){           
            eI+=nums[i]; 
        }
        
        sI = 1;
        while(sI<=eI){
            long mid = (sI+eI)/2;
            if(nonPositive(nums,mid)){
                eI=mid-1;
            }
            else sI=mid+1;
        }
        return (int)sI;
    }
    private boolean nonPositive(int[] nums,long k){

        long count = 0;
        for(int i = 0;i<nums.length;i++){
            count+=(nums[i]+k-1)/k; // here we count the ceil value.
        }
        return (int)count<=k*k;
    }
}
/*
Explanation:
Approach 1 (Binary Search on Answer):

For a positive integer k, define nonPositive(nums, k) as the minimum number of operations needed to make every element of nums non-positive. In one operation, you can choose an index i and reduce nums[i] by k.


steps to be followed.

1.Make a search space where our answer is lieing , (1 to sum(nums))->serachSpace.

2.Do a binary Search on the search Space and for each mid take a decision whether to shrink our search space from left or from right.

3.Decision is based on the count of number of operations needed to make every element of nums non-positive.

4. if nonPositive() func returns true so that it means from mid to eI we defenetly get our answer but since question is asking for minimum we shrink right part and start searching from sI to mid-1 bcz minimum is fall on the left part of our search space and vice versa.

5. return sI as our ans becoz its the minimum value whcih satisfies all the constraints.

Time_Complexity - O(n*log(sum))
Space_Complexity - O(1)



*/


// Question - Subsets II
// Problem Link - https://leetcode.com/problems/subsets-ii/
// Platform - LeetCode
package SubsequencesPattern;
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);// we sort the array so that we can easily skip the duplicates and make our result unique without using map or dictionary.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums,res);
        return res;
        
    }
// Approach 1 - Recursion And BackTracking  
    public void helper(int[] nums,int sI,List<List<Integer>> res,List<Integer> ds){
        if(sI>=nums.length){ // baseCase - whenEver sI hit the length of input array just stop the process add the ds into the res and then return to the the previous recursion call Stack.
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[sI]);// pick the current Element.
        helper(nums,sI+1,res,ds);
        ds.remove(ds.size()-1); // not pick the current Element
        while(sI<nums.length-1 && nums[sI]==nums[sI+1])sI++; // this loop just help to skip the duplicates element So, that final result are unique.
        helper(nums,sI+1,res,ds);
    }
//  Approach 2 - iterative
    public void helper(int[] nums,List<List<Integer>> res){
        
        res.add(new ArrayList<>());
        int start = 0;      
        for(int k = 0;k<nums.length;k++){
           int size = res.size();           
            if(k>0 && nums[k-1] == nums[k]){     // when consecutive element are duplicates           
                for(int i = start;i<size;i++){   // iterate from the starting index where the subsets are added previously in the res. 
                  List<Integer> subset = new ArrayList<>(res.get(i));                  
                  subset.add(nums[k]);
                  res.add(subset);
                }
                start = size; // now,set the previous size of res to start so start contains the starting indx from where the subset start inserting into res.
            }
            else{
              start = size; // now,set the previous size of res to start so start contains the starting indx from where the subset start inserting into res.
              for(int i = 0;i<size;i++){ // iterate from the begging as no duplicates element are present so current element are pick up in each previous subsets.
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(nums[k]);
                res.add(subset);
                }
            }
        }

    }


/* 
Explanation:-
Appraoch 1 - Recursion And  BackTracking

This is a intuiutive Approach of finding the subsets but in this the only modification is done is that to make the subset unique we sort the array so that we can skip the duplicate element easily.
And we have two option for each number whether to pick or not.

Time And Space Complexity -
Time - O((2^n) + NLOGN)
Space - O(2^n);

Approach 2 :- (iterative) 

While iterating through all numbers, for each new number, we can either pick it or not pick it
1, if pick, just add current number to every existing subset.
2, if not pick, just leave all existing subsets as they are.
We just combine both into our result.

For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
Combine them, now we have [ [ ], [1] ] as all possible subset

Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
Combine them, now we have [ [ ], [1], [2], [1,2] ]

Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]
Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]

But the main Catch in this question is that the input array contains duplicate whcih leads to duplicate subsets .
So,for that we keep track of the staring index in the res from where the subsets are start adding into the res.
by keeping track of index we get to know where to add the current element and where to leave as it is.

for example {1,2,2}
[[]] initially we have an empty array
for 0th index i have two option pick or not if pick then array become [[],[1]],start index for newly added subset is 1/size of res before inserting new subset.

for 1th index array become  [[],[1],[2],[1,2]],and start index for newly added subset is 2/size of res before inserting new subset. 

for 2nd index the element is same as previous element and here the start is came into the game as we know start=2 so we start adding the current element to each subset in the res from start.
[[],[1],[2],[1,2],[2,2],[1,2,2]].Why so bcz the reason is simple there is no sense of generating subset from the start bcz as we already pick that duplicate element before and genrate every possible subset till that element.


Time And Space Complexity -
Time - O(N*K) 
Space - O(K)
K is the number of subset


*/

 

public static void main(String[] args){
    Solution sol = new Solution();
    int[] nums = {1,2,2};
    List<List<Integer>> res = sol.subsetsWithDup(nums);
    System.out.println(res);
    

}
}


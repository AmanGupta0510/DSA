//Question - Subsets
//Problem Link - https://leetcode.com/problems/subsets/
// Platform - LeetCode


package SubsequencesPattern;
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n : nums){
            int size = res.size();
            for(int i = 0;i<size;i++){
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(n);
                res.add(subset);
            }
        } 
        return res;
    }
    // public void helper(int[] nums,int sI,List<Integer> temp,List<List<Integer>> res){
    //     res.add(new ArrayList<>(temp)); // for every call we add the temp into our res. 
    //     for(int i = sI;i<nums.length;i++){ // this loop takes care of base Case.   
    //         temp.add(nums[i]); // add the current element.
    //         helper(nums,i+1,temp,res); // recursive Call. 
    //         temp.remove(temp.size()-1); // remove the current element.
    //     }
    // }
}

// Explanation :-
/*
Approach 1 :- (Recursive and BackTracking)
So,the main intuition for this kind of problems are that Consider the current element as the part of the subsets or not consider the current element as the part of the subsets.
if take it as a part of subset then do the recursive Call go for the other index.
if not then remove it from the temp and go for the next index
 
let's say input array - [1,2]
Expected Output - [[],[1],[1,2],[2]]


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

*/


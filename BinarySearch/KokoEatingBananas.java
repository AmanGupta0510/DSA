

/*
Question_Name - Koko Eating Bananas
Problem_Link - https://leetcode.com/problems/koko-eating-bananas/
PlatFrom - LeetCode
 */

package BinarySearch;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int sI = 1;
       int eI = 0;
        for(int i = 0;i<piles.length;i++){
            // sI = Math.min(sI,piles[i]);
            eI = Math.max(eI,piles[i]);
        }
        
        while(sI<=eI){
           int mid = sI+(eI-sI)/2;
            if(possible(piles,h,mid)){
                eI=mid-1;
            }
            else{
                sI = mid+1;
            }
        }
        return sI;
    }
    private boolean possible(int[] piles,int h,int k){
        long count = 0;
        for(int i = 0;i<piles.length;i++){
           count += (int) (((long)piles[i] + k - 1) / k);

        }
        return count<=h;
    }
}
/*
Explanation - 
Approach 1 - (Binary Search)
As the question is about to find minimum k such that koko can eat all bananas within h hours.
So,we have to find a ideal number which can be our optimal ans,and our ans is between the range of 1 to max(bananas).
So,we have a search space between 1 to max(bananas),so we can apply a binary search and figure out which number is our ans by checking it through a function possible(which generally check the whether the given k can be eaten by koko within h hours or not, if not then return false or true)
if the current number can be my ans then we minimize our search space by moving eI to the mid-1 bcz we need minimum.
And after finishing the search we get the min number k.

Time Complexity - O(n*logm),m is the max bananas in the array.
Space Complexity - O(1);
 */


package SlidingWindow;

import java.util.PriorityQueue;

class Solution {
    private class Pair{

        long sum;
        int indx;
        public Pair(long sum , int indx){
            this.sum = sum;
            this.indx = indx;
        }

    }
    public int shortestSubarray(int[] nums, int k) {

        // int ans = Integer.MAX_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int sum  = 0;
        //     for(int j = i;j<nums.length;j++){
        //         sum+=nums[j];
        //         if(sum>=k && ans>(j-i+1)){
        //             ans = j-i+1;
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.sum , b.sum));

        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i= 0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>=k){
                ans = Math.min(ans , i+1);
            }
            while(!pq.isEmpty() && sum - pq.peek().sum >= k){
                ans = Math.min(ans , i - pq.poll().indx);
            }
            pq.add(new Pair(sum , i ));
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;


        

    }

}

/**
Explanation:
Appraoch 1 : Naive
Generate all the possible subarray and for each subarray check its sum if it is >= K and the length of the substring is less than the current one then update the ans as we need the Minimum subarray length.

Time Complexity - O(N^2) as we run loop twice.
Space Complexity - O(1)

Approach 2 : Better than Naive (Using MIN HEAP)
The intuition is simple
1. Calculate the prefix sum.
2. If currentPrefixSum >= K, update ans with (currentIndex + 1) since the subarray starts at index 0.
3. While the Min-Heap is not empty AND (currentPrefixSum - heap.top().sum >= K):
   - Calculate subarray length = currentIndex - heap.top().index.
   - Update ans = min(ans, subarray length).
   - Poll heap.top()
4. Push (currentPrefixSum, currentIndex) into the Min-Heap.

Time Complexity - O(NLOGN) N as we traverse the array and logN for pq operation (add , peek , poll)

Space Complexity - O(N) in the worst case if we can't find the anwer then pq contains the preffix sum for each index.

 */

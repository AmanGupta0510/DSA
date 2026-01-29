// Question_Name - Minimum Cost of ropes
// Problem_Link - https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
// Platform  - GeeksForGeeks

package PriorityQueues;
class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int ans = 0;
        for(int i  = 0;i<arr.length;i++){ // put all the element into min heap
            pq.offer(arr[i]);
        }
        while(pq.size()>1){ // add first two minimum element until the min Heap size != 1.
            int x = pq.poll(); // since we r using min heap so by default peek() element are the min.
            int y = pq.poll();
            ans+=(x+y);
            pq.offer(x+y);
        }
        
        return ans;
    }
}
// Note if we need to use min val again and again and may be new min can be formed and need to use it correctly
// then we first thought a min Heap approach.

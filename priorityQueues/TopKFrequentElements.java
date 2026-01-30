// Question_Name - Top K Frequent Elements
// problem_Link -  https://leetcode.com/problems/top-k-frequent-elements/
// PlatForm - LeetCode

package PriorityQueues;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        // count the freq of each element. // O(n)
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else map.put(nums[i],1);
        }
         
        // traverse through the map and maintain a k size min heap on the basis of freq. O(n * logk)
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            while(pq.size()>k){
                pq.poll();
            } // log n-k
            pq.offer(new int[]{m.getKey(),m.getValue()}); // log k
        }
        if(pq.size() > k)pq.poll();

        int[] ans = new int[pq.size()];

        int x = 0;

        while(!pq.isEmpty()){ //O(k)
            ans[x++] = pq.poll()[0];
        } 
        return ans;
    }
}
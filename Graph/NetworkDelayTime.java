// Problem_Name -  Network Delay time
// Problem_Link - https://leetcode.com/problems/network-delay-time/
// Platform - LeetCode

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkDelayTime {




    class Pair{
        int node;
        int dist;
        public Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Shortest path solution kindOf thing

        int[] dist = new int[n+1];
        for(int i = 0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i<times.length;i++){
            adjList.get(times[i][0]).add(new Pair(times[i][1] , times[i][2]));
        }

        dist[k] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));
        while(!q.isEmpty()){

            Pair t  = q.poll();

            for(Pair i : adjList.get(t.node)){
                if(t.dist+i.dist < dist[i.node]){
                    dist[i.node] = t.dist+i.dist;
                    q.add(new Pair(i.node,dist[i.node]));
                }
            }
        } 
        int ans = -1;
        for(int i = 1;i<=n;i++){
           ans = Math.max(ans,dist[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
/**

Standard Dijkstra finds the shortest path to all nodes.
So , we just need to find the max number from all the shortest path. 
So, then only we get the minimum time to takes all the n nodes to receive the signal.
Time_Complexity  - O(E) , E = number of edges
Space_Complexity - O(E)

 */


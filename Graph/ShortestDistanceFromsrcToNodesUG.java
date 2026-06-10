package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromsrcToNodesUG {
    class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist = new int[V];
        for(int i =0;i<dist.length;i++)dist[i] = (int)1e9;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            for(int i :adj.get(node)){
                 
                if(dist[node]+1 < dist[i]){
                    dist[i] = dist[node]+1;
                    q.add(i);
                } 
            }
        }
        
        for(int i = 0;i<dist.length;i++){
            if(dist[i] == 1e9){
                dist[i]  = -1;
            }
        }
        return dist;
    }
}

/*



*/
}

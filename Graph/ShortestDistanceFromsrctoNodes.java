// User function Template for Java
// Problem_Name - Shortest path in Directed Acyclic Graph
// Problem_Link - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// Platform - GFG 


package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromsrctoNodes {



    
    class Pair{
        int node;
        int weight;
        public Pair(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i= 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)1e9;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0));
        dist[0]  = 0;
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int n = p.node;
            int wt = p.weight;
            
            for(Pair i : adj.get(n)){
                
                    if(dist[n] + i.weight < dist[i.node]){
                        dist[i.node] = dist[n] + i.weight;
                        q.add(new Pair(i.node , dist[i.node]));
                    }
                  
            }
            
        }
        
        for(int i = 0;i<dist.length;i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
        
    }
}
/*
Explanation:
Approach 1 (BFS + Greedy):
1.Build an adjacency list for the given directed graph.

2.Initialize a distance array with MAX_VALUE to track the shortest distance from the source to each node.

3.Run BFS traversal: For each node, compare its current distance 
with the distance to its adjacent nodes and update with the minimum distance


*/



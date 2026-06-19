// Question_Name -  Number of Ways to Arrive at Destination
// Problem_Link -   https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
// Platform - LeetCode

package Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class NumberOfWaysToArriveDestination {

    class Pair{
        int node;
        long time;
        public Pair(int node , long time){
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        
        List<List<Pair>> adjList = new ArrayList<>();
       
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i<roads.length;i++){
            adjList.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2])); 
        }// here, i am converting the bi-directional(undirected graph) into directed Acyclic graph bcz Dijkstra applied on DAG only.   
        return helper(n,adjList);
        



    }
    private int helper(int n , List<List<Pair>> adjList){
        
        long[] dist = new long[n];
        long[] ways = new long[n];

        for(int i = 0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
        }
        PriorityQueue<Pair> q  =  new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        q.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;
        while(!q.isEmpty()){

            Pair p = q.poll();
            int node = p.node;
            long time =  p.time;
            if(time > dist[node])continue; 
            for(Pair i : adjList.get(node)){
              
                if(i.time+time <= dist[i.node] ){
                    if(i.time+time == dist[i.node]){
                        ways[i.node] = (ways[i.node]+ways[node])%1000000007;
                        continue;
                    }
                    else ways[i.node] = ways[node];
                    dist[i.node] = i.time+time;
                    q.add(new Pair(i.node,dist[i.node]));
                }
            }
        }

       
        return (int)ways[n-1];

    }

    
}

/**
Explanation:
Appraoch 01 (Dijkstra Algo + DFS):
The First approach comes to my mind after understanding the problem is that first, Find the shortest minimum time for each node.
and then take out the dist[n-1] and call the dfs starting from the 0 to explore all the possible path to n-1 and whenver we encounter with the (node==n-1 && min_possible_time==time) increase the count.
But this approach will work but gives TLE for large n (input).
Time_Complexity - O(nlogV + 2^E).
space_Complexoty - O(nlogV + 2^E).

Approach 02 (Dijkstra Algo + calculate ways parallely).
Apply Dijkstra Algo. and apply below logic to deal with calculation of ways. 
When exploring an edge from a current_node to a neighbor:

A Strictly Shorter Path is Found (new_time < dist[neighbor]):
The old paths to this neighbor are obsolete.

Update dist[neighbor] = new_time.

Overwrite the ways: ways[neighbor] = ways[current_node].

Push the neighbor into the PriorityQueue.

An Equal Length Path is Found (new_time == dist[neighbor]):
You found a completely new tie-game route that reaches this neighbor in the exact same optimal time.

Accumulate the ways: ways[neighbor] = (ways[neighbor] + ways[current_node]) % MOD.

Do not push to the PriorityQueue again (to avoid duplicate processing TLE).

Time_Complexity - O(E log V)
Space_Complexity - O(V+E)

 */
    


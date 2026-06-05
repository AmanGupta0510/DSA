
// Question_Name - Find Eventual Safe States
// Problem_Link -  https://leetcode.com/problems/find-eventual-safe-states/
// PlatForm - LeetCode

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheEventualSafeState {



    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> res = new ArrayList<>();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            indegree[i] = graph[i].length;
            for(Integer j : graph[i]){
                adjList.get(j).add(i);
            }
        }
        Queue<Integer> topo = new LinkedList<>();

        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0)topo.add(i);
        } 

        while(!topo.isEmpty()){

            int size = topo.size();
            while(size-->0){
               int node = topo.poll();
            //    res.add(node);
                for(int i : adjList.get(node)){
                  indegree[i]--;
                  if(indegree[i] == 0)topo.add(i);
                }
            }
        }

        for(int i= 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                res.add(i);
            }
        }

        return res;

    }
}
/**
Explanation:
Approach (Topological sort):
The question is saying about to find all the safe nodes 
Safe Nodes are those where the Path starting from that node leads to terminal node.
*A node is a terminal node if there are no outgoing edges.

The best way of doing it is to just reverse the edges means make outgoing edges to ingoing edges or vice-versa.
Reversing the edges allows us to treat terminal nodes as starting points (sources) and trace backward to find all nodes that safely lead to them.

The Approach :
1.Reverse the edges,for that use adjacencyList.
2.Find the indegree,Note that the original out-degrees become the new in-degrees because we reversed the edges.
3.Find all the nodes with zero indegree and put it in the queue.
4.Apply topological sort Alogorithm to find out all the safe nodes.

Time Complexity - O(V+E)
Space Complexity - O(V+E)

 */


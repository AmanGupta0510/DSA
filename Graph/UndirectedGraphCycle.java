// Question_Name - Undirected Graph Cycle
// Problem_Link -   https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Platform - GeeeksForGeeks

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {

    class Pair {
        int nodes;
        int parents;

        public Pair(int nodes, int parents) {
            this.nodes = nodes;
            this.parents = parents;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here

        // let first convert the edges into the adjacency list.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCycle(adjList, visited, i)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int node) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int v = p.nodes;
            int parent = p.parents;

            for (Integer i : adjList.get(v)) {

                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Pair(i, v));

                } else if (parent != i) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
 * Explanation:
 * Approach (BFS):
 * 
 * 1.First of all convert the edges into adjList for ease.
 * 2.Start from the First node (0).
 * 3.Put node and its parent in the queue to start the BFS traversal.
 * 4.While performing BFS check whether the node is visited already by some
 * other nodes.
 * (note: we will be using parent so that we get to know that the visited node
 * is the parent of current node or something different so that we can easily
 * find out the cycle bcz if the visited node is not parent so it means it is
 * touched by someone else and now current node also trying to touch it so it
 * create a cycle and by keeping this in mind we can say whether the cycle is
 * found or not .)
 * 
 * 
 * 
 * 
 * 
 */

// Question - Is Graph Bipartite
// Problem_link - https://leetcode.com/problems/is-graph-bipartite/
// Platform - LeetCode 

package Graph;

public class IsBipartiteGraph {
    



    public boolean isBipartite(int[][] graph) {
        
        int[] color = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(!visited[i]){
                if(!dfs(graph,color,visited,-1,i))return false;
            }
        }
        return true;

    }
    private boolean dfs(int[][] graph , int[] color , boolean[] visited , int col,int node){

        visited[node] = true;
        color[node] = col;
        for(Integer i : graph[node]){
            if(color[node]==color[i]){
                return false;
            }
            if(!visited[i]){
                if(!dfs(graph,color,visited, col==-1?1:-1,i))return false;
            }
        }
        return true;
    } 
}

/**
Explanation :
Approach DFS:

The intuition behind the solution is that while traversing the nodes put the color and if there any adjacent nodes whose color is identical then straightway return false.
1.For each node between 0 to n-1 run a loop and run a dfs function for all the unvisited node.
2.In the dfs mark  the node visited and put the col like -1 or 1.
3.Call the dfs recursively for all the adjacent unvisited node and if there any identical color found between any adjacent nodes then straight away return false and after that we dont need to traverse further.

Time_Complexity - O(N+E)
Space_Complexity - O(N)



 */

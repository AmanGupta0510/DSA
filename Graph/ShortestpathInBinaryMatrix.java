// Question_Name - Shortest Path in Binary matrix
// Problem_Link -  https://leetcode.com/problems/shortest-path-in-binary-matrix/
// Platform - LeetCode


package Graph;

import java.util.PriorityQueue;

public class ShortestpathInBinaryMatrix {
    




    class Triplet{
        int dist;
        int row;
        int col;
        public Triplet(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length-1;
        if(grid[0][0] == 1 || grid[n][n] == 1)return -1;

        boolean[][] visited = new boolean[grid.length][grid.length];
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        pq.add(new Triplet(1,0,0));
       
        while(!pq.isEmpty()){

            Triplet t = pq.poll();
          
            if(t.row==n && t.col == n)return t.dist;

            int[][] direction = {{1,0},{0,1},{0,-1},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
            for(int i=0;i<direction.length;i++){
                int newDist = t.dist+1;
                int newR = t.row + direction[i][0];
                int newC = t.col + direction[i][1];
                if(newR>=0 && newC>=0 && newR<=n && newC<=n && grid[newR][newC] == 0 && !visited[newR][newC]){
                    visited[newR][newC] = true;
                    pq.add(new Triplet(newDist,newR,newC));
                }
            }

        }
        return -1;
    }
}

/**
Explanation:
Approach 1:
Use dijkstra Algorithm.

Time Complexity -  O(M*N * log(M*N))
Space Complexity - O(M*N)
*/

// Question_Name - Path With Minimum Effort
// Problem_Link -  https://leetcode.com/problems/path-with-minimum-effort/
// Platform - LeetCode

package Graph;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {






    class Triplet{
        int row;
        int col;
        int efforts;

        public Triplet(int efforts,int row, int col){
            this.efforts = efforts;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)-> a.efforts-b.efforts);
        int n = heights.length-1;
        int m = heights[0].length-1; 
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        pq.add(new Triplet(0,0,0));
       
        while(!pq.isEmpty()){

            Triplet t = pq.poll();
            if(t.row == n && t.col == m)return t.efforts;
            for(int i = 0;i<dirs.length;i++){
                visited[t.row][t.col] = true;
                int newR = t.row+dirs[i][0];
                int newC = t.col+dirs[i][1];
                if(newR>=0 && newC>=0 && newR<=n && newC<=m && !visited[newR][newC]){
                    int newEffort = Math.max(Math.abs(heights[newR][newC] - heights[t.row][t.col]) , t.efforts);
                    pq.add(new Triplet(newEffort,newR,newC));
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
    


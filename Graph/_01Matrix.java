package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {

    // Question_Name -  01 Matrix
// Problem_Link -  https://leetcode.com/problems/01-matrix/
// Platform - Leetcode

    class Triplet{
        int row;
        int col;
        int distance;
        public Triplet(int r , int c , int d){
            this.row = r;
            this.col = c;
            this.distance  = d; 
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Triplet> q  = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j] == 0){
                   q.add(new Triplet(i,j,0));
                }
            }
        }
        int[][] distArray  = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int r = t.row;
            int c = t.col;
            int dist = t.distance;
           
           
            distArray[r][c] = dist;
            int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

           for(int[] i : dirs){
            int nr = r+i[0];
            int nc = c+i[1];
           
            if(nr>=0 && nr<mat.length && nc<mat[0].length && nc>=0){
                if(mat[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Triplet(nr,nc,dist+1));
                }
              
              
            }
           }
        }

        return distArray;
        
    }
}
    



// Question Name - Flood Fill
// Problem_Link -  https://leetcode.com/problems/flood-fill/
// Platform - Leetcode

package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color)return image;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int oGcolor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()){

            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int[][] dirs = {{1,0} , {-1,0} , {0,1} , {0,-1}};

            for(int[] d : dirs){
                int r = row+d[0];
                int c = col+d[1];
                if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == oGcolor){
                    image[r][c] = color;
                    q.add(new Pair(r,c));
                }
            } 
        }

        return image;

    }
}
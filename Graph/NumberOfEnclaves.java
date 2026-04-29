// Question_Name -  Number of Enclaves
// Problem_Link -   https://leetcode.com/problems/number-of-enclaves/
// Platform - Leetcode


package Graph;

public class NumberOfEnclaves {
   
    public int numEnclaves(int[][] grid) {
        
        // do border traversal and find out the land cell and for that call the recursion to mark all its adjacent (4-directional) cells.

        for(int i = 0;i<grid.length;i++){
            if(grid[i][0] == 1)markCell(grid,i,0);
            if(grid[i][grid[0].length-1] == 1)markCell(grid,i,grid[0].length-1);
        } 
        for(int j = 1;j<grid[0].length;j++){
            if(grid[0][j] == 1)markCell(grid,0,j);
            if(grid[grid.length-1][j] == 1)markCell(grid,grid.length-1,j);
        }

        return helper(grid);
        
    }

    private void markCell(int[][] grid , int row , int col){

        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]!=1){
            return;
        }
        grid[row][col] = -1;
        markCell(grid,row+1,col);
        markCell(grid,row-1,col);
        markCell(grid,row,col+1);
        markCell(grid,row,col-1);
    }
    private int helper(int[][] grid){
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1)count+=1;
            }
        }
        return count;
    }


}
// TIme Complexity - O(m*n)
// Space Complexity - O(1) , excluding recursion stack space.




// Question - Number if Islands
// Problem_Link - https://leetcode.com/problems/number-of-islands/
// Platform - Leetcode


package Graph;

public class NumberOfIslands {
   

    public int numIslands(char[][] grid) {
        
        int count  = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count+=1;
                    helper(grid,i,j);
                }
            }
        }
        return count;

    }
    
    private void helper(char[][] grid,int row , int col ){
        
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] == '1'){
            grid[row][col] = '#';
            helper(grid,row+1,col);
            helper(grid,row-1,col);
            helper(grid,row,col+1);
            helper(grid,row,col-1);
        }
        
    }
}
// Explanation:
/*
Approach:
Simple DFS

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
grid with value '1' is considered as land and '0' as water.

So, the appraoch are simple
1.Iterate over the grid,Increment the count  whenever a grid value is '1' and run a dfs for it in which we are just marks its vertically and horizontally 
adjacent grid.
2.Recursively we mark all the adjacent cells.

TimeComplexity - O(m*n)
SpaceComplexity - O(m*n)

* */


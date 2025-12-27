/*
Question_Name - Rat in a maze
Problem_Link - https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
PlatForm - GeeksForGeeks

*/
package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        String path = "";
        boolean[][] visited = new boolean[maze.length][maze.length];
        helper(maze,0,0,visited,path,res);
        return res;
    }
    public void helper(int[][] maze,int r,int c,boolean[][] visited,String path,ArrayList<String> res){
        
        if(r==maze.length-1 && c == maze[0].length-1){
            res.add(path);
            return;
        }
        
        if(r<0 || r>=maze.length || c>=maze[0].length || c<0)return;
        
        if(maze[r][c] == 1 && !visited[r][c]){
        visited[r][c] = true;
       
        helper(maze,r+1,c,visited,path+"D",res);
        helper(maze,r,c-1,visited,path+"L",res);
        helper(maze,r,c+1,visited,path+"R",res);
        helper(maze,r-1,c,visited,path+"U",res);
        visited[r][c] = false;
        }
        
    }
    
}

/*
Expalanation:-
The Appraoch we are using is BackTracking.

The question is saying to find out all possible path in the matrix starting from 0 to n-1
we can move (up,down,left,right) only if there is a free cell .

we start finding all possible path by keeping in mind the constraint
if we reach at n-1th index of the cell then we add the current path to the res and backtrack to find more such possible path.
After exploring all possible path our res contains all those path and we return that as our ans.

Time Complexity - O(n*n * 4^k) where k is the number of cells present in the maze.
Space Complexity - O(n*n).




*/

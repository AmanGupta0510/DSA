// Question Name - Word Search
// Problem Link - https://leetcode.com/problems/word-search/
// Platform - LeetCode
package RecursionAndBacktracking;
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board,visited,word,i,j,1))return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,boolean[][] visited,String word,int sI,int eI,int indx){

        if(indx==word.length())return true;
        visited[sI][eI] = true;
        boolean ans1 = false;
        boolean ans2 = false;
        boolean ans3 = false;
        boolean ans4 = false;
        if(eI-1>=0 && !visited[sI][eI-1] && board[sI][eI-1]==word.charAt(indx)) ans1 = helper(board,visited,word,sI,eI-1,indx+1);
        if(eI+1<=board[0].length-1 && !visited[sI][eI+1] && board[sI][eI+1]==word.charAt(indx)) ans2 = helper(board,visited,word,sI,eI+1,indx+1);
        if(sI-1>=0 && !visited[sI-1][eI] && board[sI-1][eI]==word.charAt(indx)) ans3 = helper(board,visited,word,sI-1,eI,indx+1);
        if(sI+1<board.length && !visited[sI+1][eI] && board[sI+1][eI]==word.charAt(indx)) ans4 = helper(board,visited,word,sI+1,eI,indx+1);
        visited[sI][eI] = false;
        return ans1||ans2||ans3||ans4;
    }

}

/*
Explanation:-
The first Approach comes to my mind is backtracking after reading the Question.
Basically question says find whether the word is in the board or not.
We can move horizontally or vertically to search the word in the board matrix.

Approach:
Use DFS + backtracking on the grid. We iterate over every cell 
and treat it as a possible starting point if it matches the first character of the word. 
From such a cell, we run a recursive DFS that tries to match the next characters by moving up, down, left, and right. 
To avoid reusing the same cell in the current path, we mark it as visited (for example by temporarily changing its value) before exploring neighbors, and restore it when backtracking.
If the DFS reaches index == word.length, it means we have matched all characters, so we return true. If all starting cells and all paths fail, we return false.

Time complexity: O(m * n * 4^L), where m and n are the board dimensions and L is the length of the word.


Space complexity: O(L) for the recursion stack (if we mark visited in-place).



 */
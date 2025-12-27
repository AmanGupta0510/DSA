// Question_Name - N_Queens
// Problem_Link - https://leetcode.com/problems/n-queens/
// Platform - LeetCode


package RecursionAndBacktracking;
import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        boolean[][] chessBoard = new boolean[n][n];
        helper(n,chessBoard,ds,res,0,0);
        return res;
    }
    private void helper(int n,boolean[][] chessBoard,List<String> ds,List<List<String>> res,int r,int c){
        if(c==n){
            List<String> board = new ArrayList<>();
            for (int i = 0; i < chessBoard.length; i++) {
                char[] row = new char[chessBoard.length];
                Arrays.fill(row, '.');
                for (int j = 0; j < chessBoard.length; j++) {
                    if (chessBoard[i][j]) row[j] = 'Q';
                }
                board.add(new String(row));
            }
            res.add(board);
            return;
        }  

        for(int i = 0;i<n;i++){
            if(validCell(chessBoard,i,c)){
                chessBoard[i][c] = true;
                helper(n,chessBoard,ds,res,r,c+1);
                chessBoard[i][c] = false;
            }
        }
    }
    private boolean validCell(boolean[][] chessBoard,int r,int c){
        for(int i = 0;i<chessBoard.length;i++){
           if(chessBoard[i][c]==true || chessBoard[r][i]==true)return false;
        }
        int i = r;int j = c;
        // L_up_diag
        while(i>=0 && j>=0){
            if(chessBoard[i][j]==true)return false;
            i-=1;
            j-=1;
        }
        // R_Down_diag
        i = r;j=c;
        while(i<chessBoard.length && j<chessBoard.length){
            if(chessBoard[i][j]==true)return false;
            i+=1;
            j+=1;
        }
        // R_up_Diag
        i=r;j=c;
        while(i>=0 && j<chessBoard.length){
            if(chessBoard[i][j]==true)return false;
            i-=1;
            j+=1;
        }
        // L_down_Diag
        i=r;j=c;
        while(i<chessBoard.length && j>=0){
            if(chessBoard[i][j]==true)return false;
            i+=1;
            j-=1;
        }
       return true;
    }
}

/*
The N-Queens problem places n queens on an n×n board so no two attack each other (same row, column, or diagonal). 
Use backtracking to try positions col-by-col: place a queen if safe, recurse to next col; if invalid or no solution, backtrack. 
When n queens are placed successfully, add the board to results.

Time: O(n!) – tries n positions per row with pruning.
Space: O(n²) – for the board.

*/

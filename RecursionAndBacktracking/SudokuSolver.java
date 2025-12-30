

/**
Question_Name - Sudoku Solver
Problem_Link -  https://leetcode.com/problems/sudoku-solver/
PlatForm - LeetCode
 */

package RecursionAndBacktracking;
class Solution {
    public void solveSudoku(char[][] board) {
        
        helper(board);

    }
    private boolean helper(char[][] board){

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                if(board[i][j] == '.' ){
                    for(char ch = '1';ch<='9';ch++){
                        if(valid(board,i,j,ch)){
                            board[i][j] = ch;
                            if(helper(board))return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
    private boolean valid(char[][] board,int r,int c,char ch){
        for(int i = 0;i<9;i++){
            if(board[i][c] == ch || board[r][i] == ch)return false;
            if(board[3*(r/3)+i/3][3*(c/3)+i%3]==ch)return false; 

        }
        return true;
    }
}

/*
Explanation - 
Appraoch - BackTracking
The idea is to generate all possible digit for every empty cells
For every cells we pass our digit in a Valid method where it is checked that the digits can be fitted or not in the current cell
if yes then we recurse for other empty cells Or if not then we loop to the next digit and so on..
If for any cell we fail to put any digit between 1-9,then we simply backtract and try another digit for the cell.
If our program return true then we straight away return true bcz we got our possible /valid sudoku.

Time Complexity - O(N*N*9)
Space Complexity - O(recursion stack)
thank you 






 */

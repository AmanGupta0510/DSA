package Graph;

public class SurroundedRegion {
    
    // Question_Name - Surrounded Regions
// Problem_Link -  https://leetcode.com/problems/surrounded-regions/
// Platform  - LeetCode


    class Pair{
        int row;
        int col;
        public Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {

        //  BFS
        // boolean[][] visited = new  boolean[board.length][board[0].length];
        // Queue<Pair> q = new LinkedList<>(); 
        // for(int i = 0;i<board.length;i++){
        //     for(int j = 0;j<board[0].length;j++){
        //         if(i==0 || i==board.length-1){
        //             if(board[i][j] == 'O'){
        //                 q.add(new Pair(i,j));
        //             }
        //         }
        //         else if(j==0 || j==board[0].length-1){
        //             if(board[i][j] == 'O'){
        //                 q.add(new Pair(i,j));
        //             }
        //         }
        //     }
        // } 
        // // M*N

        // while(!q.isEmpty()){

        //     Pair p = q.poll();
        //     int row = p.row;
        //     int col = p.col;
        //     // System.out.println(row+" "+col);
        //     visited[row][col] = true;
        //     int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        //     for(int[] i : dirs){
        //         int nr = row+i[0];
        //         int nc = col+i[1];
        //         if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length){
        //             if(!visited[nr][nc] && board[nr][nc] == 'O'){
        //                 q.add(new Pair(nr,nc));
        //             }
                   
        //         }
        //     } 
        // }
        // // M*N

        // for(int i = 0;i<visited.length;i++){
        //     for(int j = 0;j<visited[0].length;j++){
        //         if(!visited[i][j]){
        //            board[i][j] = 'X';
        //         }
        //     }
        // }
        // // M*N


        // DFS
        // Mark border
        for(int i = 0;i<board.length;i++){  // mark left-most and right-most border. 
            if(board[i][0] == 'O')markBorder(board,i,0);
            if(board[i][board[0].length-1] == 'O')markBorder(board,i,board[0].length-1);
        }
        for(int j = 1 ; j<board[0].length;j++){ // mark top-most and bottom-most border.
            if(board[0][j] == 'O')markBorder(board,0,j);
            if(board[board.length-1][j] == 'O')markBorder(board,board.length-1,j);
        } 
        markRegion(board,'O','X'); // mark all 'O' cells NOT connected (directly or indirectly) to any border 'O' as 'X';
        markRegion(board,'A','O'); // restore the cell 'A' back to 'O' (these are the ones connected to border 'O');



      


        
    }
    private void markBorder(char[][] board , int row , int col){

        if(row<0 || row >= board.length || col<0 || col>=board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'A';
        markBorder(board, row + 1, col);
        markBorder(board, row, col + 1);
        markBorder(board, row - 1, col);
        markBorder(board, row, col - 1);
        
    }
    private void markRegion(char[][] board , char src , char target){

        for(int i= 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
               if(board[i][j] == src)board[i][j] = target;
            }
        }

    }

}

// Both DFS and BFS solution have same time complexity and difference between both solution is about the space complexity 
// In BFS we are using an extra M*N space but in DFS except the recusion stack space we are not using any kind of extra space.


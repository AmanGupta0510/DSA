// Question Name - Rotting Oranges
// Problem_Link  - https://leetcode.com/problems/rotting-/oranges/
// Platform - Leetcode


package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    



    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        return helper(grid, q);

    }

    private int helper(int[][] grid, Queue<Pair> q) {
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;
                grid[row][col] = 2;

                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    q.add(new Pair(row + 1, col));
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    q.add(new Pair(row - 1, col));
                }
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    q.add(new Pair(row, col + 1));
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    q.add(new Pair(row, col - 1));
                }
            }
            count += 1;

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return count == 0 ? 0 : count - 1;

    }

}

/**
Explantion:
Approach (Multi-Source BFS)

1.Add all the rotten oranges to queue simultaneously.
2.Do a BFS traversal level by level .
3.For each rotten orange, check the 4 neighbours:
   if fresh then rot it and add it to the queue.
4.return the count.   

Time Complexity - O(M*N)
Space Complexity - O(M*N)





 */ 


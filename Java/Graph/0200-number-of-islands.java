/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or 
vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '0') {
                    continue;
                }
                if (grid[row][col] == 'x') {
                    continue;
                }
                islands++;
                dfs(grid, row, col);
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (col < 0 || col > grid[0].length-1) {
            return;
        }

        if (row < 0 || row > grid.length-1) {
            return;
        }

        if (grid[row][col] == '0') {
         return;   
        }

        if (grid[row][col] == 'x') {
            return;
        }

        grid[row][col] = 'x';

        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
    }
}
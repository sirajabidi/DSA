/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner 
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot 
include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
*/

class Solution {
    static int paths = 0;

    private int _uniquePaths(int row, int col, int[][] grid, int[][] cache) {
        if (col < 0) {
            return 0;
        }

        if (row < 0) {
            return 0;
        }

        if (grid[row][col] == 1) {
            return 0;
        }

        if ((row == 0) && (col == 0)) {
            return 1;
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        int pathFromLeft = _uniquePaths(row, col-1, grid, cache);
        int pathFromTop = _uniquePaths(row-1, col, grid, cache);
        int totalPaths = pathFromLeft + pathFromTop;
        cache[row][col] = totalPaths;
        return totalPaths;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            int val = obstacleGrid[0][0];
            if (val == 0) {
                return 1;
            }
            if (val == 1) {
                return 0;
            }
        }

        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }

        return _uniquePaths(obstacleGrid.length-1, obstacleGrid[0].length-1, obstacleGrid, cache);
    }
}
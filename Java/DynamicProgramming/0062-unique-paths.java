/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either 
down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
*/


/* NOTE : 
    Just use a DP-Table which is 2D matrix of same size as original grid to hold the unique-paths value in which you can
    reach a particular cell. Once the DP table is all filled just return the value of the botton-right most cell.
*/

class Solution {
    /*
    private int _uniquePaths(int r, int c, int[][] cache) {
        if (c < 0) {
            return 0;
        }

        if (r < 0) {
            return 0;
        }

        if (r==0 && c==0) {
            return 1;
        }

        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        
        int pathsLeft = _uniquePaths(r, c-1, cache);
        int pathsTop = _uniquePaths(r-1, c, cache);
        int totalPaths = pathsLeft + pathsTop;
        cache[r][c] = totalPaths;
        return totalPaths;
    }

    public int uniquePaths(int m, int n) {
        if ((m < 1) || (n < 1)) {
            return 0;
        }

        int[][] cache = new int[m][n];
        for (int[] row: cache) {
            Arrays.fill(row, 0);
        }
        return _uniquePaths(m-1, n-1, cache);
    }
    */

    public int uniquePaths(int m, int n) {
        if (m==0 || n==0) {
            return 0;
        }
        if (m==1 || n==1) {
            return 1;
        }
        int[][] grid = new int[m][n];
        for(int i=0; i<=m-1; i++) {
            for(int j=0; j<=n-1; j++) {
                if (i==0) {
                    grid[i][j] = 1;
                } else if (j==0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        return grid[m-1][n-1];
            
    }
}
/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || (grid.length == 0)) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        for (int r = 0; r <= rows - 1; r++) {
            for (int c = 0; c <= cols - 1; c++) {

                if (grid[r][c] == 0) {
                    continue;
                }
                // if found land cell - check all the 4 neighbors

                // left Neighbor :
                boolean considerLeftEdge = false;
                if (c == 0) {
                    considerLeftEdge = true;
                } else if (grid[r][c-1] == 0) {
                    considerLeftEdge = true;
                }

                if (considerLeftEdge) {
                    perimeter = perimeter + 1;
                }

                // right neighbor
                boolean considerRightEdge = false;
                if (c == cols - 1) {
                    considerRightEdge = true;
                } else if (grid[r][c+1] == 0) {
                    considerRightEdge = true;
                }

                if (considerRightEdge) {
                    perimeter = perimeter + 1;
                }

                // top neighbor
                boolean considerTopEdge = false;
                if (r == 0) {
                    considerTopEdge = true;
                } else if (grid[r-1][c] == 0) {
                    considerTopEdge = true;
                }

                if (considerTopEdge) {
                    perimeter = perimeter + 1;
                }

                // right neighbor
                boolean considerBottomEdge = false;
                if (r == rows - 1) {
                    considerBottomEdge = true;
                } else if (grid[r+1][c] == 0) {
                    considerBottomEdge = true;
                }

                if (considerBottomEdge) {
                    perimeter = perimeter + 1;
                }
            }
        }
        return perimeter;
    }
}
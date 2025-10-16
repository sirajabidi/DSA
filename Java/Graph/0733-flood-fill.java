/*
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]
*/

class Cell {
    int r = -1;
    int c = -1;
    Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length == 0) {
            return new int[0][0];
        }

        int imageRows = image.length;
        int imageColumns = image[0].length;

        int[][] visited = new int[image.length][image[0].length];
        for(int[] row : visited) {
            Arrays.fill(row, 0);
        }

        int colorAtReferenceCell = image[sr][sc];

        Queue<Cell> queue = new LinkedList<Cell>();
        Cell startCell = new Cell(sr, sc);
        queue.add(startCell);
        visited[sr][sc] = 1;

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            image[cell.r][cell.c] = color;

            // left cell if not visited :
            int leftCellRow = cell.r;
            int leftCellCol = cell.c-1;
            if ((leftCellRow >= 0 &&  leftCellRow <= imageRows-1) && 
                (leftCellCol >= 0 && leftCellCol <= imageColumns-1) && 
                (visited[leftCellRow][leftCellCol] == 0) &&
                (image[leftCellRow][leftCellCol] == colorAtReferenceCell)) {
                queue.add(new Cell(leftCellRow, leftCellCol));
                visited[leftCellRow][leftCellCol] = 1;
            }

            // right cell if not visited :
            int rightCellRow = cell.r;
            int rightCellCol = cell.c+1;
            if ((rightCellRow >= 0 &&  rightCellRow <= imageRows-1) && 
                (rightCellCol >= 0 && rightCellCol <= imageColumns-1) && 
                (visited[rightCellRow][rightCellCol] == 0) &&
                (image[rightCellRow][rightCellCol] == colorAtReferenceCell)) {
                queue.add(new Cell(rightCellRow, rightCellCol));
                visited[rightCellRow][rightCellCol] = 1;
            }

            // top cell if not visited :
            int topCellRow = cell.r-1;
            int topCellCol = cell.c;
            if ((topCellRow >= 0 &&  topCellRow <= imageRows-1) && 
                (topCellCol >= 0 && topCellCol <= imageColumns-1) && 
                (visited[topCellRow][topCellCol] == 0) &&
                (image[topCellRow][topCellCol] == colorAtReferenceCell)) {
                queue.add(new Cell(topCellRow, topCellCol));
                visited[topCellRow][topCellCol] = 1;
            }

            // bottom cell if not visited :
            int bottomCellRow = cell.r+1;
            int bottomCellCol = cell.c;
            if ((bottomCellRow >= 0 &&  bottomCellRow <= imageRows-1) && 
                (bottomCellCol >= 0 && bottomCellCol <= imageColumns-1) && 
                (visited[bottomCellRow][bottomCellCol] == 0) &&
                (image[bottomCellRow][bottomCellCol] == colorAtReferenceCell)) {
                queue.add(new Cell(bottomCellRow, bottomCellCol));
                visited[bottomCellRow][bottomCellCol] = 1;
            }            
        }

        return image;
    }
}
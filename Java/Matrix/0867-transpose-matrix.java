/*
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
*/
class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Square matrix: do in-place transpose
        if (rows == cols) {
            for (int r = 0; r <= rows - 1; r++) {
                for (int c = r + 1; c <= cols - 1; c++) {
                    int tmp = matrix[r][c];
                    matrix[r][c] = matrix[c][r];
                    matrix[c][r] = tmp;
                }
            }
            return matrix;
        }

        // Non-square: allocate a new matrix (m x n -> n x m)
        int newRows = cols; // previous columns become new rows
        int newCols = rows; // previous rows become new columns
        int[][] newMatrix = new int[newRows][newCols];

        for (int r = 0; r <= rows - 1; r++) {
            for (int c = 0; c <= cols - 1; c++) {
                newMatrix[c][r] = matrix[r][c];
            }
        }

        return newMatrix;
    }
}
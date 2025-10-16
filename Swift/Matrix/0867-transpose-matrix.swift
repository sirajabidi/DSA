/*
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
*/

class Solution {
    func transpose(_ matrix: [[Int]]) -> [[Int]] {
        // If empty matrix, just return it
        if matrix.isEmpty || matrix[0].isEmpty {
            return matrix
        }
        
        // If square matrix we can do in-place transpose
        if matrix.count == matrix[0].count {
            var matrixCopy = matrix
            for r in 0..<matrixCopy.count {
                for c in 0..<matrixCopy[0].count {
                    let tmp = matrixCopy[c][r]
                    matrixCopy[c][r] = matrixCopy[r][c]
                    matrixCopy[r][c] = tmp
                }
            }
            return matrixCopy
        }
        
        // Else, non-square: allocate new matrix
        let newMatrixRows = matrix[0].count
        let newMatrixCols = matrix.count
        
        // Initialize new 2D matrix with 0s
        var newMatrix: [[Int]] = Array(repeating: Array(repeating: 0, count: newMatrixCols), count: newMatrixRows)
        
        var wR = 0
        var wC = 0
        for c in 0..<matrix[0].count {
            for r in 0..<matrix.count {
                newMatrix[wR][wC] = matrix[r][c]
                if wC == newMatrixCols - 1 {
                    wR += 1
                    wC = 0
                } else {
                    wC += 1
                }
            }
        }
        
        return newMatrix
    }
}
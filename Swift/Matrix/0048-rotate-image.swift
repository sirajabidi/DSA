class Solution {
   func rotate(_ matrix: inout [[Int]]) {
        if (matrix.isEmpty) {
            return
        }
        
        var rows = matrix.count
        var colums = matrix[0].count
        
        // Transpose:
        for r in 0...rows-1 {
            for c in r...colums-1 {
                var tmp = matrix[c][r]
                matrix[c][r] = matrix[r][c]
                matrix[r][c] = tmp
            }
        }

        // now reverse the transposed marix:
        for r in 0...rows-1 {
            var f = 0
            var b = colums-1
            while (f < b) {
                var tmp = matrix[r][f]
                matrix[r][f] = matrix[r][b]
                matrix[r][b] = tmp
                f = f + 1
                b = b - 1
            }
        }
    }
}
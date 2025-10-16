class Solution {
    func spiralOrder(_ matrix: [[Int]]) -> [Int] {
        if (matrix.isEmpty) {
            return []
        }
        var rows = matrix.count
        var columns = matrix[0].count
        
        if (rows == 1) {
            return matrix[0]
        }
        
        if (columns == 1) {
            var result: [Int] = Array()
            for r in 0...rows-1 {
                result.append(matrix[r][0])
            }
            return result
        }
        
        var result: [Int] = Array()
        
        var topRow = 0
        var rightCol = columns-1
        var bottomRow = rows-1
        var leftCol = 0
        
        while ((topRow < bottomRow) && (leftCol < rightCol)) {
            // traverse top row:
            for c in leftCol...rightCol-1 {
                result.append(matrix[topRow][c])
            }
            
            // traverse right column :
            for r in topRow...bottomRow-1 {
                result.append(matrix[r][rightCol])
            }
            
            // traverse bottomRow:
            for c in (leftCol+1...rightCol).reversed() {
                result.append(matrix[bottomRow][c])
            }
            
            // traverse leftColumn:
            for r in (topRow+1...bottomRow).reversed() {
                result.append(matrix[r][leftCol])
            }
            
            topRow = topRow + 1
            rightCol = rightCol - 1
            bottomRow = bottomRow - 1
            leftCol = leftCol + 1
        }

        if ((topRow == bottomRow) && (leftCol == rightCol)) {
            result.append(matrix[topRow][leftCol])
        }
        
        if ((topRow == bottomRow) && (leftCol < rightCol)) {
            for c in leftCol...rightCol {
                result.append(matrix[topRow][c])
            }
        }
        
        if ((leftCol == rightCol) && (topRow < bottomRow)) {
            for r in topRow...bottomRow {
                result.append(matrix[r][leftCol])
            }
        }
        
        return result
        
    }
}
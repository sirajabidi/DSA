class Solution {
    func _findDiagonalOrderDfs(_ r: Int, _ c: Int, _ level: Int, _ mat: [[Int]], _ explored: inout [[Bool]], _ result: inout [[Int]]) {
        if (c > mat[0].count-1) {
            return
        }
        
        if (r > mat.count-1) {
            return
        }
        
        if (explored[r][c] == true) {
            return
        }
        
        explored[r][c] = true
        var levelIsEven = level % 2 == 0
        
        if (result.count >= level) {
            if (levelIsEven) {
                result[level-1].append(mat[r][c])
            } else {
                result[level-1].insert(mat[r][c], at: 0)
            }
        } else {
            var newDiagonal: [Int] = []
            newDiagonal.append(mat[r][c])
            result.append(newDiagonal)
        }

        _findDiagonalOrderDfs(r, c+1, level+1, mat, &explored, &result)
        _findDiagonalOrderDfs(r+1, c, level+1, mat, &explored, &result)
    }

    func findDiagonalOrder(_ mat: [[Int]]) -> [Int] {
        if (mat.isEmpty) {
            return []
        }
        
        if (mat.count == 1) {
            return mat[0]
        }
        
        if (mat[0].count == 1) {
            var result: [Int] = []
            for i in mat {
                result.append(i[0])
            }
            return result
        }
        
        var explored: [[Bool]] = Array(repeating: Array(repeating: false, count: mat[0].count), count: mat.count)

        var levelOrderTraversal : [[Int]] = []
        _findDiagonalOrderDfs(0, 0, 1, mat, &explored, &levelOrderTraversal)
        
        var result : [Int] = []
        for i in levelOrderTraversal {
            result.append(contentsOf: i)
        }
        return result

    }
}
class Solution {
    func zigzagTraversal(_ grid: [[Int]]) -> [Int] {
        if (grid.isEmpty) {
            return []
        }
        
        if (grid.count == 1 && grid[0].count == 1) {
            return [grid[0][0]]
        }
        
        var result: [Int] = []
        
        for r in 0...grid.count-1 {

            if (r % 2 == 0) {
                var sI = 0
                var eI = grid[0].count-1
                while (sI <= eI) {
                    result.append(grid[r][sI])
                    sI += 2
                }
                
            } else {
                var sI = (grid[0].count % 2 == 0) ? grid[0].count-1 : grid[0].count-2
                
                while (sI >= 0) {
                    result.append(grid[r][sI])
                    sI -= 2
                }
            }
        }
        
        return result
    }
}
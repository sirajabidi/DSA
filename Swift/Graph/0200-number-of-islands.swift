class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {
        if (grid.count == 0) {
            return 0;
        }
        
        var localGrid = grid
        
        var rows = localGrid.count
        var columns = localGrid[0].count
        
        var islands = 0
        var queue: [[Int]] = Array();
        
        for row in 0...localGrid.count-1 {
            for col in 0...localGrid[0].count-1 {
                
                if (localGrid[row][col] == "1") {
                    islands += 1
                    
                    var currentCell = [row, col]
                    queue.append(currentCell)
                    localGrid[row][col] = "0"
                    
                    while (queue.count != 0) {
                        var tmp = queue.removeFirst()
                        // left Neighbour :
                        var tmpRow = tmp[0]
                        var tmpCol = tmp[1] - 1
                        if ((tmpRow >= 0 && (tmpRow <= rows-1)) &&
                            (tmpCol >= 0) && (tmpCol <= columns-1) &&
                            (localGrid[tmpRow][tmpCol] == "1")) {
                            queue.append([tmpRow, tmpCol])
                            
                            localGrid[tmpRow][tmpCol] = "0"
                            
                        }
                        
                        // Right Neighbour :
                        tmpRow = tmp[0]
                        tmpCol = tmp[1] + 1
                        if ((tmpRow >= 0 && (tmpRow <= rows-1)) &&
                            (tmpCol >= 0) && (tmpCol <= columns-1) &&
                            (localGrid[tmpRow][tmpCol] == "1")) {
                            queue.append([tmpRow, tmpCol])
                            
                            localGrid[tmpRow][tmpCol] = "0"
                            
                        }
                        
                        // Top Neighbour :
                        tmpRow = tmp[0] - 1
                        tmpCol = tmp[1]
                        if ((tmpRow >= 0 && (tmpRow <= rows-1)) &&
                            (tmpCol >= 0) && (tmpCol <= columns-1) &&
                            (localGrid[tmpRow][tmpCol] == "1")) {
                            queue.append([tmpRow, tmpCol])
                            
                            localGrid[tmpRow][tmpCol] = "0"
                            
                        }
                        
                        // Bottom Neighbour :
                        tmpRow = tmp[0] + 1
                        tmpCol = tmp[1]
                        if ((tmpRow >= 0 && (tmpRow <= rows-1)) &&
                            (tmpCol >= 0) && (tmpCol <= columns-1) &&
                            (localGrid[tmpRow][tmpCol] == "1")) {
                            queue.append([tmpRow, tmpCol])
                            
                            localGrid[tmpRow][tmpCol] = "0"
                            
                        }
                    }
                }
                
            }
        }
        return islands
    }
}
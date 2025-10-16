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
    func _islandPerimeterDfs(r: Int, c: Int, grid: [[Int]], explored: inout [[Bool]], perimter: inout Int) {
        if (r < 0 || r > grid.count-1) {
            return
        }
        if (c < 0 || c > grid[0].count-1) {
            return
        }
        if (grid[r][c] == 0) {
            return
        }
        if (explored[r][c]) {
            return
        }
        
        explored[r][c] = true
        
        var leftNeighbor = (c-1 < 0) ? 0 : grid[r][c-1]
        if (leftNeighbor == 0) {
            perimter = perimter + 1
        }
        
        var rightNeighbor = (c+1 > grid[0].count-1) ? 0 : grid[r][c+1]
        if (rightNeighbor == 0) {
            perimter = perimter + 1
        }
        
        var topNeighbor = (r-1 < 0) ? 0 : grid[r-1][c]
        if (topNeighbor == 0) {
            perimter = perimter + 1
        }
        
        var bottomNeighbor = (r+1 > grid.count-1) ? 0 : grid[r+1][c]
        if (bottomNeighbor == 0) {
            perimter = perimter + 1
        }
        
        _islandPerimeterDfs(r: r, c: c+1, grid: grid, explored: &explored, perimter: &perimter)
        _islandPerimeterDfs(r: r, c: c-1, grid: grid, explored: &explored, perimter: &perimter)
        _islandPerimeterDfs(r: r-1, c: c, grid: grid, explored: &explored, perimter: &perimter)
        _islandPerimeterDfs(r: r+1, c: c, grid: grid, explored: &explored, perimter: &perimter)
    }


    func islandPerimeter(_ grid: [[Int]]) -> Int {
        if (grid.isEmpty) {
		return 0
        }
        
        if (grid.count == 1 && grid[0].count == 1) {
            return 4
        }
        
        var explored : [[Bool]] = Array(repeating: Array(repeating: false, count: grid[0].count), count: grid.count)
        var perimeter = 0
        
        for r in 0...grid.count-1 {
            for c in 0...grid[0].count-1 {
                if (grid[r][c] == 1) {
                    _islandPerimeterDfs(r: r, c: c, grid: grid, explored: &explored, perimter: &perimeter)
                    break
                }
            }
        }
        
        return perimeter
    }
}
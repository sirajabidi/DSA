//
//  ZigZagTraversal.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/19/25.
//

import Foundation

/*
 You are given an m x n 2D array grid of positive integers.

 Your task is to traverse grid in a zigzag pattern while skipping every alternate cell.

 Zigzag pattern traversal is defined as following the below actions:

 Start at the top-left cell (0, 0).
 Move right within a row until the end of the row is reached.
 Drop down to the next row, then traverse left until the beginning of the row is reached.
 Continue alternating between right and left traversal until every row has been traversed.
 Note that you must skip every alternate cell during the traversal.

 Return an array of integers result containing, in order, the value of the cells visited
 during the zigzag traversal with skips.


 */


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

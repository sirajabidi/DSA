//
//  PrintAllDiagonals.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/19/25.
//

import Foundation
/*
 Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 
 https://leetcode.com/problems/diagonal-traverse/description/
 
 */


func _findDiagonalOrderDfs(_ r: Int, _ c: Int, _ level: Int, _ mat: [[Int]], _ explored: inout [[Bool]], _ result: inout [[Int]]) {
	
	
	/* INSIGHT:
	 Applied level order tree-traversal technique. Basically matrix is a graph - where each node is conected to the right
	 child and bottom child. Right and Bottom child are the same level.
	 Eg : cell(0,0) has right-child(0,1) and bottom-child as (1,0). and now both these right and bottom child is at level 2 in a diagonal
	 sense. Cell(0,0) is at level 1. Similarly the child of Cell(0,1) is Right->(0,2) & Bottom->(1,1) they both are at level 3.
	 
	 All we now have to do is apply DFS , track the already explored cells so that we don't DFS twice on it and the level.
	 And stuff it in the array inside the result associated with the level number.
	 
	 If in zig-zig fashion track the level and based on odd/even either appned at first or at last.
	 
	 NOTE : non zig-zag fashion diagonla traversal can also be done in this same way
	 */

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

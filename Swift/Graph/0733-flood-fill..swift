//
//  FloodFill.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/19/25.
//

import Foundation


/*
 You are given an image represented by an m x n grid of integers image, where image[i][j] represents
 the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to
 perform a flood fill on the image starting from the pixel image[sr][sc].

 To perform a flood fill:

 Begin with the starting pixel and change its color to color.
 Perform the same process for each pixel that is directly adjacent (pixels that share a side with
 the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
 Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their
 color if it matches the original color of the starting pixel.
 The process stops when there are no more adjacent pixels of the original color to update.
 Return the modified image after performing the flood fill.

  

 Example 1:

 Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

 Output: [[2,2,2],[2,2,0],[2,0,1]]


 */

func _floodFillDfs( _ r: Int, _ c: Int, _ srcColor : Int, _ targetColor: Int, _ image:[[Int]],
					_ resultImage: inout [[Int]], _ explored: inout [[Bool]]) {
		
	if (r < 0 || r > image.count-1) {
		return
	}
	
	if (c < 0 || c > image[0].count-1) {
		return
	}
	
	if (explored[r][c]) {
		return
	}
	
	explored[r][c] = true
	
	if (image[r][c] != srcColor) {
		return
	}
	
	resultImage[r][c] = targetColor
	_floodFillDfs(r, c+1, srcColor, targetColor, image, &resultImage, &explored)
	_floodFillDfs(r, c-1, srcColor, targetColor, image, &resultImage, &explored)
	_floodFillDfs(r+1, c, srcColor, targetColor, image, &resultImage, &explored)
	_floodFillDfs(r-1, c, srcColor, targetColor, image, &resultImage, &explored)
}

func floodFill(_ image: [[Int]], _ sr: Int, _ sc: Int, _ color: Int) -> [[Int]] {
	if (image.isEmpty) {
		return []
	}
	
	var resultImage = image
	var explored: [[Bool]] = Array(repeating: Array(repeating: false, count: image[0].count), count: image.count)
	_floodFillDfs(sr, sc, image[sr][sc], color, image, &resultImage, &explored)
	return resultImage
}

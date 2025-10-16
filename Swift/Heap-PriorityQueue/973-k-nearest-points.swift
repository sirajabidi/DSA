//
//  973-k-nearest-points.swift
//  swift-leetcode
//
//  Created by SirajAbidi on 10/16/25.
//

import Foundation
import HeapModule

class Pair : Comparable {
	var distance: Int
	var x : Int
	var y: Int
	
	init(distance: Int, x: Int, y: Int) {
		self.distance = distance
		self.x = x
		self.y = y
	}
	
	// MARK: - Comparable conformance
	static func < (lhs: Pair, rhs: Pair) -> Bool {
		return lhs.distance < rhs.distance
	}
	
	static func == (lhs: Pair, rhs: Pair) -> Bool {
		return lhs.distance == rhs.distance
	}
	
	static func > (lhs: Pair, rhs: Pair) -> Bool {
		return lhs.distance > rhs.distance
	}
}

func kNearestPairsHeapify(_ points: [[Int]], _ origin: [Int], _ k: Int) -> [[Int]] {
	
	var distances: Heap<Pair> = Heap()
	
	for point in points {
		let x = point[0]
		let y = point[1]
		// Calculate actual distance from origin
		let deltaX = x - origin[0]
		let deltaY = y - origin[1]
		let distance = deltaX * deltaX + deltaY * deltaY // Using squared distance to avoid sqrt
		
		let newPair = Pair(distance: distance, x: x, y: y)
		
		if distances.count >= k {
			// If heap is full and new distance is smaller than max, replace max
			if let maxPair = distances.max {
				if (newPair.distance < maxPair.distance) {
					distances.removeMax()
					distances.insert(newPair)
				}
			}
		} else {
			distances.insert(newPair)
		}
	}
	
	// Convert heap to array and return k nearest pairs
	var result: [[Int]] = Array()

	while !distances.isEmpty {
		var pair: Pair = distances.removeMax()
		var point: [Int] = Array()
		point.append(pair.x)
		point.append(pair.y)

		result.append(point)
	}
	
	return result
}

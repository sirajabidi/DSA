//
//  CheapestFlightWithinKStops.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/26/25.
//

import Foundation
import HeapModule

/*
 There are n cities connected by some number of flights. You are given an array
 flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight
 from city fromi to city toi with cost pricei.

 You are also given three integers src, dst, and k, return the cheapest price from
 src to dst with at most k stops. If there is no such route, return -1.
 */


class FlightPair : Comparable {
	var city: Int
	var priceFromSource: Int
	var distanceFromSource: Int
	
	init(_ c: Int, _ p: Int, _ d: Int) {
		self.city = c
		self.priceFromSource = p
		self.distanceFromSource = d
	}
	
	public static func < (lhs: FlightPair, rhs: FlightPair) -> Bool {
		return lhs.priceFromSource < rhs.priceFromSource
	}
	
	public static func == (lhs: FlightPair, rhs: FlightPair) -> Bool {
		return lhs.priceFromSource == rhs.priceFromSource
	}
}

func findCheapestPrice(_ n: Int, _ flights: [[Int]], _ src: Int, _ dst: Int, _ k: Int) -> Int {
	var adjList : [Int: [[Int]]] = Dictionary()
	
	for i in 0...n-1 {
		adjList[i] = []
	}

	for item in flights {
		let s = item[0]
		let d = item[1]
		let p = item[2]
		
		adjList[s]!.append([d, p])
	}
	
	var prices: [Int] = Array(repeating: Int.max, count: n+1)
	var distances: [Int] = Array(repeating: Int.max, count: n+1)
	
	var heap: Heap<FlightPair> = Heap()
	let sourceNode = FlightPair(src, 0, 1)
	
	heap.insert(sourceNode)
	
	prices[src] = 0
	distances[src] = 0

	while !heap.isEmpty {
		let current: FlightPair = heap.popMin()!

		if (current.city == dst) {
			return current.priceFromSource
		}
		
		// if k stops are allowed : this means k+1 edges are allowed
		if (current.distanceFromSource >= k+1) {
			continue
		}
		
		/* NOTE:
		   We can't use a boolean "explored" array to perfrom the pruning here. Beacuse when we mark a node as
		   explpored we do so because to reach that node we have found the best path but in this case it might be
		   the best path in terms of price but might have not fulfilled the k stops constraints. Hence a lazy-pruning
		   approach.
		*/
		if (current.priceFromSource > prices[current.city] && current.distanceFromSource > distances[current.city]) {
			continue
		}
	
		for item in adjList[current.city]! {
			let neighbor = item[0]
			let neighborEdgePrice = item[1]
			
			let neighborNewPrice = current.priceFromSource + neighborEdgePrice
			let neighborNewDistance = current.distanceFromSource + 1
			
			if (neighborNewPrice < prices[neighbor] ||
				neighborNewDistance < distances[neighbor]) {
				
				if (neighborNewPrice < prices[neighbor]) {
					prices[neighbor] = neighborNewPrice
				}
				
				if (neighborNewDistance < distances[neighbor]) {
					distances[neighbor] = neighborNewDistance
				}
				
				let newNode = FlightPair(neighbor, neighborNewPrice, neighborNewDistance)
				heap.insert(newNode)
			}
		}
	}
	
	return -1
}

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as
 directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, 
 and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to 
receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
*/


import HeapModule

class TimePair : Comparable {
	var val : Int
	var timeFromSource: Int
	
	init(_ val: Int, _ timeFromSource: Int) {
		self.val = val
		self.timeFromSource = timeFromSource
	}
	
	static func < (lhs: TimePair, rhs: TimePair) -> Bool {
		return lhs.timeFromSource < rhs.timeFromSource
	}
	
	static func == (lhs: TimePair, rhs: TimePair) -> Bool {
		return lhs.timeFromSource == rhs.timeFromSource
	}
}

class Solution {
    func networkDelayTime(_ times: [[Int]], _ n: Int, _ k: Int) -> Int {
        var adjList: [Int: [[Int]]] = Dictionary()
        for i in 1...n {
            adjList[i] = []
        }
        
        for item in times {
            var s = item[0]
            var d = item[1]
            var t = item[2]
            
            adjList[s]!.append([d, t])
        }

        var explored : [Bool] = Array(repeating: false, count: n+1)
    
        var source: TimePair = TimePair(k, 0)
        var heap: Heap<TimePair> = Heap()
        heap.insert(source)
        
        var times: [Int] = Array(repeating: Int.max, count: n+1)
        times[k] = 0
        
        while !heap.isEmpty {
            var currentNode: TimePair = heap.popMin()!

            if (explored[currentNode.val]) {
			    continue
		    }

            var neighbors: [[Int]] = adjList[currentNode.val]!

            for item in neighbors {
                var n = item[0]
                var t = item[1]
                
                if (times[n] > currentNode.timeFromSource+t) {
                    var newTimePairFromCurrentNode = TimePair(n, currentNode.timeFromSource+t)
                    heap.insert(newTimePairFromCurrentNode)
                    times[n] = currentNode.timeFromSource + t
                }
            }

            explored[currentNode.val] = true
        }
        
        var result = Int.min

        for i in 1...times.count-1 {
            if (i == k) {
                continue
            }
            if (times[i] > result) {
                result = times[i]
            }
        }

        return (result == Int.max) ? -1 : result
    }
}
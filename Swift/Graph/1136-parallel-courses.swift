//
//  ParallelCourses.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/16/25.
//

import Foundation


/*
 You are given an integer n, which indicates that there are n courses labeled from 1 to n.
You are also given an array relations where relations[i] = [prevCoursei, nextCoursei],
 representing a prerequisite relationship between course prevCoursei and
 course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

 In one semester, you can take any number of courses as long as you have taken all the
 prerequisites in the previous semester for the courses you are taking.

 Return the minimum number of semesters needed to take all courses.
 If there is no way to take all the courses, return -1.
 */


/* INSIGHT : Needs to be solved via : longestPath in the graph. Challenge is to find the longestPath.
   We will use backtracking for this - and the node which has no dependents is the node at level 1
   and now all the nodes on top of this is particular node is at level+1 or level+2 etc. depending on
   how for it is from this 0-children node.
*/
func _maxPathDfs(_ c: Int, _ adjList: [Int: [Int]], _ explored: inout [Bool], _ current: inout [Int]) -> Int {

	if (explored[c]) {
		return 0
	}

	current.append(c)
	
	var maxPaths: [Int] = []

	for d in adjList[c]! {
		if (current.contains(d)) {
			return -1
		}
		var maxPath: Int = _maxPathDfs(d, adjList, &explored, &current)
		if (maxPath == -1) {
			return -1
		}
		maxPaths.append(maxPath)
	}

	explored[c] = true
	current.removeLast()

	return (maxPaths.max() ?? 0) + 1
}

func minimumSemesters(_ n: Int, _ relations: [[Int]]) -> Int {
	if (relations.isEmpty) {
		return 0
	}

	var adjList : [Int: [Int]] = Dictionary()
	for c in 1...n {
		adjList[c] = []
	}
	
	for pair in relations {
		adjList[pair[0]]!.append(pair[1])
	}

	var explored: [Bool] = Array(repeating: false, count: n+1)
	var current: [Int] = []
	var semesters = 0
	
	for c in 1...n {
		if (explored[c]) {
			continue
		}

		var maxPath: Int = _maxPathDfs(c, adjList, &explored, &current)
		if (maxPath == -1) {
			return -1
		}

		semesters = max(semesters, maxPath)
	}

	return semesters
}



//*****************************************************************************************


func minimumSemestersKanhsAlgo(_ n: Int, _ relations: [[Int]]) -> Int {
		// convert prerequisites to AdjacenccyList:
		var adjList: [[Int]] = Array(repeating: Array(), count: n+1)

		var indegrees: [Int] = Array(repeating: 0, count: n+1)

		for item in relations {
			var courseTag = item.first;
			var dependency = item.last;
			if (courseTag == dependency) {
				return -1
			}

			adjList[courseTag!].append(dependency!)
			indegrees[dependency!] = indegrees[dependency!] + 1
		}
		
		print("adjList:", adjList)
		print("indegrees:", indegrees)

		var queue: [[Int]] = Array()
		
		var tmp: [Int] = Array()
		for course in 1...n {
			if (indegrees[course] == 0) {
				tmp.append(course)
			}
		}
		queue.append(tmp)

		
		print("queue:", queue)
		
		var result: [[Int]] = Array()

		while (!queue.isEmpty) {
			var semesterCourses = queue.removeFirst()
			print("semesterCourses:", semesterCourses)
			result.append(semesterCourses)
			
			var samesterContainer: [Int] = Array()
			
			for semesterCourse in semesterCourses {
				print("semesterCourse:", semesterCourse)
				
				var courseDependencyList = adjList[semesterCourse]
				print("courseDependencyList:", courseDependencyList)
				
				for dependentCourse in courseDependencyList {
					print("dependentCourse:", dependentCourse)
					indegrees[dependentCourse] = indegrees[dependentCourse] - 1
					if (indegrees[dependentCourse] == 0) {
						samesterContainer.append(dependentCourse)
					}
				}
			}
			if (samesterContainer.count > 0) {
			   queue.append(samesterContainer)
			}
			
		}
		
		var totalCount = 0
		for semesterContainer in result {
			totalCount = totalCount + semesterContainer.count
		}
		
		if (totalCount != n) {
			return -1
		}
		return result.count
		
	}

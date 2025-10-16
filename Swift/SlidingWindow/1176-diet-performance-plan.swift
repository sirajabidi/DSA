//
//  DietPlanPerformance.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/17/25.
//

import Foundation

/*
 A dieter consumes calories[i] calories on the i-th day.

 Given an integer k, for every consecutive sequence of k days
 (calories[i], calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T,
 the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):

 If T < lower, they performed poorly on their diet and lose 1 point;
 If T > upper, they performed well on their diet and gain 1 point;
 Otherwise, they performed normally and there is no change in points.
 Initially, the dieter has zero points. Return the total number of points the
 dieter has after dieting for calories.length days.

 Note that the total points can be negative.

  

 Example 1:

 Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 Output: 0
 Explanation: Since k = 1, we consider each element of the array separately and compare it to lower and upper.
 calories[0] and calories[1] are less than lower so 2 points are lost.
 calories[3] and calories[4] are greater than upper so 2 points are gained.
 */


func dietPlanPerformance(_ calories: [Int], _ k: Int, _ lower: Int, _ upper: Int) -> Int {
	
	var prefixArray : [Int] = []
	
	for i in 0...calories.count-1 {
		var prefixCalorie = (i == 0) ? calories[i] : (prefixArray[i-1] + calories[i])
		prefixArray.append(prefixCalorie)
	}
	
	var wS = -1
	var wE = k-1
	var points = 0
	
	while (wE <= prefixArray.count-1) {
		var totalCaloriesInWindow = prefixArray[wE] - ((wS >= 0) ? prefixArray[wS] : 0)
		
		if (totalCaloriesInWindow < lower) {
			points = points - 1
		}
		if (totalCaloriesInWindow > upper) {
			points = points + 1
		}
		wE += 1
		wS += 1
	}
	return points
}

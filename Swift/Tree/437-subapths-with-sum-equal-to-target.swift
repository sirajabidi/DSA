//
//  TreeAllSubpathsEqualToTargetSum.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/15/25.
//

import Foundation

/*
 Given the root of a binary tree and an integer targetSum, return the
 number of paths where the sum of the values along the path equals targetSum.

 The path does not need to start or end at the root or a leaf, but it must
 go downwards (i.e., traveling only from parent nodes to child nodes).
 */



// NOTE : This has to be done using PreficSum technique.
/* Insight : As we are _dfs-ing through the tree we are pushing the sum of each level to the next level
             and this represent prefix-sum from root to the current node. Now to find a sub-path which
             starts somewhere from middle and ends at the current node with sum equal to target has to be
			done via equation :
			
			x<some-path-starting -from-root> + target = prefixSum<this is the path starting from the root upto current node>
			>> we have to find if such "x" exists. Per above equation "x = prefixSum - target"
            
			Maintain a cache that is holding prefixPaths for a particular branch of a tree because the sub-path existence
            has to have happened only within the branch of the current node.
*/

func _dfs(_ node : TreeNode?, _ currentSum: Int, _ target: Int, _ cache: inout [Int: Int], _ pathCount: inout Int) {
	
	if (node == nil) {
		return
	}
	
	var prefixSum = currentSum + node!.val
	
	if (prefixSum == target) {
		pathCount += 1
	}
	
	var prefixSumToCheck =  prefixSum - target

	if (cache[prefixSumToCheck] != nil) {
		var totalSubPaths = cache[prefixSumToCheck]!
		pathCount = pathCount + totalSubPaths
	}
	
	/* we manage the cache so that it holds the prefixPatha only for the current branch you are
	   traversing. That's what we want - because the sub-prefixPath has to exist within the same branch
	   not else where
	 
	 */
	cache[prefixSum] = (cache[prefixSum] != nil) ? cache[prefixSum]! + 1 : 1
	
	_dfs(node?.left, prefixSum, target, &cache, &pathCount)
	_dfs(node?.right, prefixSum, target, &cache, &pathCount)
	
	cache[prefixSum] = cache[prefixSum]! - 1
	if (cache[prefixSum] == 0) {
		cache.removeValue(forKey: prefixSum)
	}
}

func pathSum(_ root: TreeNode?, _ targetSum: Int) -> Int {
	guard let root = root else {
		return 0
	}
	
	if (root.left == nil && root.right == nil) {
		if (root.val == targetSum) {
			return 1
		}
		return 0
	}
	
	var cache: [Int: Int] = Dictionary()
	var pathCount = 0

	_dfs(root, 0, targetSum, &cache, &pathCount)
	return pathCount
}

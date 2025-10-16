/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class Solution {
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
}
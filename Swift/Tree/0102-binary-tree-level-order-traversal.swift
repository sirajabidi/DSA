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
    func _helperDfs(_ node: TreeNode?, _ level: Int, _ result: inout [[Int]]) {
        guard let node = node else {return}
	
        if (result.count > level) {
            result[level].append(node.val)
        } else {
            var tmpArray: [Int] = Array()
            tmpArray.append(node.val)
            result.append(tmpArray)
        }
        _helperDfs(node.left, level+1, &result)
        _helperDfs(node.right, level+1, &result)
    }

    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        guard let root = root else {return []}
        var result: [[Int]] = Array()
        _helperDfs(root, 0, &result)
        return result
    }
}
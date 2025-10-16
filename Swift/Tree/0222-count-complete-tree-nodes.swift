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
    func _countNodes(_ node: TreeNode?) -> Int {
        guard let node = node else {return 0}
        var leftNodes = _countNodes(node.left)
        var rightNodes = _countNodes(node.right)
        return leftNodes + rightNodes + 1
    }


    func countNodes(_ root: TreeNode?) -> Int {
        guard let node = root else {return 0}
        return _countNodes(root)
    }
}
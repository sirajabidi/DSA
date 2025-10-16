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
    func inOrderTraversalDFS(_ node: TreeNode?, _ result: inout [Int]) {
        guard let node = node else {return}
        inOrderTraversalDFS(node.left, &result)
        result.append(node.val)
        inOrderTraversalDFS(node.right, &result)
    }

    func inorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let node = root else {return Array()}
        var result: [Int] = Array()
	    inOrderTraversalDFS(root, &result)
	    return result
    }
}
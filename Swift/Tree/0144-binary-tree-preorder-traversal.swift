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

    func _preOrderTraversal(_ node: TreeNode?, _ result: inout [Int]) {
        guard let node = node else {return}
        result.append(node.val)
        _preOrderTraversal(node.left, &result)
        _preOrderTraversal(node.right, &result)
	
    }
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let node = root else {return Array()}
	    var result: [Int] = Array()
	    _preOrderTraversal(root, &result)
	    return result
    }
}
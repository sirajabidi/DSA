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
    func rightSideView(_ root: TreeNode?) -> [Int] {
        if (root == nil) {
            return []
        }
        
        var rightSideView: [Int] = Array()
        
        var bfsQueue: [[TreeNode]] = Array()
        bfsQueue.append([root!])
        
        while (!bfsQueue.isEmpty) {
            var itemFromBfsQueue = bfsQueue.removeFirst()
            
            rightSideView.append(itemFromBfsQueue.last!.val)
            
            var newPackingarray: [TreeNode] = Array()
            
            for node in itemFromBfsQueue {
                if (node.left != nil) {
                    newPackingarray.append(node.left!)
                }
                
                if (node.right != nil) {
                    newPackingarray.append(node.right!)
                }
            }
            
            if (!newPackingarray.isEmpty) {
                bfsQueue.append(newPackingarray)
            }
        }
        return  rightSideView
    }
}
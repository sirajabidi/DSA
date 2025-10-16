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
    private func computeAverage(inputArray: [TreeNode]) -> Double {
        var sum: Double = 0.0;
        
        for node in inputArray {
            sum = sum + Double(node.val)
        }
        
        var average: Double = sum / Double(inputArray.count)
        return average
    }
    
    func averageOfLevels(_ root: TreeNode?) -> [Double] {
        if (root == nil) {
            return []
        }
        
        var averages: [Double] = Array()
        
        var queue: [[TreeNode]] = Array()
        queue.append([root!])
        
        while (!queue.isEmpty) {
            var item = queue.removeFirst()
            
            var average = computeAverage(inputArray: item)
            averages.append(average)
            
            var newPackingArray: [TreeNode] = Array()
            for node in item {
                if (node.left != nil) {
                    newPackingArray.append(node.left!)
                }
                
                if (node.right != nil) {
                    newPackingArray.append(node.right!)
                }
            }
            if (newPackingArray.count > 0) {
                queue.append(newPackingArray)
            }
            
        }
        
        return averages
    }
}
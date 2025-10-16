/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeDepth = maxDepth(root.left);
        int rightSubTreeDepth = maxDepth(root.right);
        
        int currentNodeDepth = 0;
        if (leftSubTreeDepth > rightSubTreeDepth) {
            currentNodeDepth = leftSubTreeDepth + 1;
        } else {
            currentNodeDepth = rightSubTreeDepth + 1;
        }
        return currentNodeDepth;
    }
}
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
    private boolean _dfs(TreeNode node, int currentSum , int targetSum) {
        if (node == null) {
            return false;
        }
        if ((currentSum == targetSum) && node.left == null && node.right == null) {
            return true;
        }
        
        boolean leftStatus = false;
        if (node.left != null) {
            leftStatus = _dfs(node.left, currentSum+node.left.val, targetSum);
        }
        if (leftStatus) {
            return true;
        }
        boolean rightStatus = false;
        if (node.right != null) {
            rightStatus = _dfs(node.right, currentSum+node.right.val, targetSum);
        }
        return rightStatus;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return _dfs(root, root.val, targetSum);
        
    }
}
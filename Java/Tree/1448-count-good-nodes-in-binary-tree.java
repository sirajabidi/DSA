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
    private int _goodNodes(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }
        int fromLeft = _goodNodes(node.left, node.val > maxValue ? node.val : maxValue);
        int fromRight = _goodNodes(node.right, node.val > maxValue ? node.val : maxValue);
        return fromLeft + fromRight + (node.val >= maxValue ? 1 : 0);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return _goodNodes(root, root.val);
        
    }
}
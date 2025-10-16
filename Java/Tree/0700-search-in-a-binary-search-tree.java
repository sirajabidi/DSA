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
    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val == val) {
            return node;
        }

        TreeNode result = null;
        if (val < node.val) {
            result = searchBST(node.left, val);
        }

        if (result != null) {
            return result;
        }

        return searchBST(node.right, val);
    }
}
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
    // height() return -1 if for specified node balance property is violated. Else it returns the correct height
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            // height() is returning -1 for left subtree meaning for specified node balanced property is being violated.
            return -1;
        }
        int rightHeight = height(node.right);
        // height() is returning -1 for right subtree meaning for specified node balanced property is being violated.
        if (rightHeight == -1) {
            return -1;
        }

        int diff = Math.abs((leftHeight - rightHeight));
        if (diff > 1) {
            // This node violates the property of balanace binary tree - (return -1)
            return -1;
        }

        // Otherwise this node does not violates the property - return the actual height of this node:
        int height = Math.max(leftHeight, rightHeight);
        return (height + 1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int height = height(root);
        if (height == -1) {
            return false;
        }
        return true;
    }
}
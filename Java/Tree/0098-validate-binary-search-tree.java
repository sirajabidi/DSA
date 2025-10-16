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
    private boolean isValidBSTDFS(TreeNode node, Integer lowerBound, Integer upperBound) {
            if (node == null) {
                return true;
            }
            if (lowerBound != null && node.val <= lowerBound) {
                return false;
            }
            if (upperBound != null && node.val >= upperBound) {
                return false;
            }

            boolean left = isValidBSTDFS(node.left, lowerBound, node.val);
            boolean right = isValidBSTDFS(node.right, node.val, upperBound);
            return left && right;
        }


        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (root.left == null && root.right == null) {
                return true;
            }

            return isValidBSTDFS(root, null , null);
        }
}
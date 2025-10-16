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
    /** check the tree under node1 and the tree under node2 for identicality. Recurse over left nodes of each and right node of each.
     */
    private boolean areIdentical(TreeNode node1 , TreeNode node2) {
        if ((node1 == null) && (node2 == null)) {
            return true;
        }

        if ((node1==null) || (node2==null) || (node1.val != node2.val)) {
            return false;
        }

        boolean leftStatus = areIdentical(node1.left, node2.left);
        if (!leftStatus) {
            return false;
        }

        boolean rightStatus = areIdentical(node1.right, node2.right);
        if (!rightStatus) {
            return false;
        }

        return true;
    }

/* Approach - check for each node we are recursing over whether the tree under that node is identical to tree under subRoot node. So we are calling areIdentical for node and subRoot node.
 */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root == subRoot) {
            return true;
        }

        boolean subTreeFound = false;

        // let's do BFS over starting with root and then for each node compare if tree under that node identical to subRoot tree:
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean identical = areIdentical(node, subRoot);
            if (identical) {
                subTreeFound = true;
                break;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return subTreeFound;
    }
}
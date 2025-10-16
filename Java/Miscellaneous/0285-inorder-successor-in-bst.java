/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode _inorderSuccessor(TreeNode node, TreeNode targetNode) {
        if (node == null) {
            return null;
        }

        if (node.val == targetNode.val) {
            if (node.right == null) {
                return new TreeNode(-999);
            } else {
                TreeNode tmp = node.right;
                while(tmp.left != null) {
                    tmp = tmp.left;
                }
                return tmp;
            }
        }

        if (targetNode.val > node.val) {
            TreeNode rightStatus = _inorderSuccessor(node.right, targetNode);
            if (rightStatus == null) {
                return null;
            } else {
                if (rightStatus.val == -999) {
                    return rightStatus;
                } else {
                    return rightStatus;
                }
            }
        } else {
            TreeNode leftStatus = _inorderSuccessor(node.left, targetNode);
            if (leftStatus == null) {
                return null;
            } else {
                if (leftStatus.val == -999) {
                    return node;
                } else {
                    return leftStatus;
                }
            }
           
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if ((root.left == null) && (root.right == null)) {
            return null;
        }
        TreeNode node = _inorderSuccessor(root, p);
        if (node.val == -999) {
            return null;
        }

        return node;
    }    
}
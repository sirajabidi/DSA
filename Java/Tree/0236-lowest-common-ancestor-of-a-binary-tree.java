

import com.sun.source.tree.Tree;

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
    /* if we have reached to the leaf then the input node is null and we return null. If the input node is equal to p OR q then it is one of the node of interest so we return that node.
    
    when the recursion for (node.left) and (node.right) retruns for the specified node we check the return values. If both node.left and node.right recursion is non-null this means we have found both p and q node underneath this node and hence this node is the LCA. If both are not non-nil then one is null and one is non-null. The non-nil one means we have found either p or q in the subtree of the specified node so we go ahead and return whatever we have found which could be p or q and continue upwards in the tree.
    
    
    */

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if ((node.val == p.val) || (node.val == q.val)) {
            return node;
        }

        TreeNode leftResult = lowestCommonAncestor(node.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(node.right, p, q);

        if ((leftResult != null) && (rightResult != null)) {
            return node;
        }

        if ((leftResult == null) && (rightResult == null)) {
            return null;
        }

        if (leftResult != null) {
            return leftResult;
        }
         return rightResult;
    }
}
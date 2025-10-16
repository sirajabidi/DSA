

import com.sun.source.tree.Tree;

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
    private int _pathSums(TreeNode node, Long currentSum, int targetSum, int paths) {
        if (node == null) {
            return paths;
        }

        if ((currentSum + Long.valueOf(node.val)) == targetSum) {
            paths = paths + 1;
        }
        paths = _pathSums(node.left, (currentSum + node.val), targetSum, paths);
        paths = _pathSums(node.right, (currentSum + node.val), targetSum, paths);
        return paths;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int totalPaths = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
            int paths = _pathSums(node, Long.valueOf(0), targetSum, 0);
            totalPaths = totalPaths + paths;
        }
        return totalPaths;
    }
}
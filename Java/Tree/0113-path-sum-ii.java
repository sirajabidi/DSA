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
    private void _dfsAllPaths(TreeNode localNode, int currentSum , int targetSum, List<TreeNode> currentPath, List<List<Integer>> allPaths) {
        if (localNode == null) {
            return;
        }
        if ((currentSum == targetSum) && localNode.left == null && localNode.right == null) {
            List<Integer> path = new ArrayList<>();

            for (TreeNode tmp : currentPath) {
                path.add(tmp.val);
            }
            allPaths.add(path);
        }

        if (localNode.left != null) {
            currentPath.add(localNode.left);
            _dfsAllPaths(localNode.left, currentSum+(localNode.left.val), targetSum, currentPath, allPaths);
            currentPath.remove(localNode.left);
        }
        

        if (localNode.right != null) {
            currentPath.add(localNode.right);
            _dfsAllPaths(localNode.right, currentSum+localNode.right.val, targetSum, currentPath, allPaths);
            currentPath.remove(localNode.right);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                List<Integer> path = new ArrayList<>();
                path.add(root.val);
                List<List<Integer>> allPaths = new ArrayList<>();
                allPaths.add(path);
                return allPaths;
            } else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> allPaths = new ArrayList<>();

        List<TreeNode> firstPath = new ArrayList<>();
        firstPath.add(root);

        _dfsAllPaths(root, root.val, targetSum, firstPath, allPaths);
        return allPaths;
    }
}
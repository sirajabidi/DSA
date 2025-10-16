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
    private void _helperRecirsiveDFS(TreeNode node, int level, List<Integer> result) {
          if (node == null) return;
          if (result.size() == level) {
              result.add(node.val);
          }
          _helperRecirsiveDFS(node.right, level + 1, result);
          _helperRecirsiveDFS(node.left, level + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        if (root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            return res;
        }
        
        List<Integer> result = new ArrayList<>();
        _helperRecirsiveDFS(root, 0, result);
        return result;
    }
}
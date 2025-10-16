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
    private void _dfsZigZagLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        List<Integer> levelList = null;
        boolean insertionRequired = false;
        
        if (result.size() >= level) {
            levelList = result.get(level-1);
        } else {
            insertionRequired = true;
            levelList = new ArrayList<>();
        }
        
        int modulus = level % 2;
        if (modulus == 0) {
            // Even level
            levelList.add(0, root.val);
        } else {
            // Odd level
            levelList.add(root.val);
        }
        if (insertionRequired) {
            result.add(levelList);
        }
        
        if (root.left != null) {
            _dfsZigZagLevelOrder(root.left, level + 1, result);    
        }
        if (root.right != null) {
            _dfsZigZagLevelOrder(root.right, level + 1, result);    
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<List<Integer>> tmp = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            tmp.add(list);
            return tmp;
        }
        List<List<Integer>> result = new ArrayList<>();
        _dfsZigZagLevelOrder(root, 1, result);
        return result;
    }
}
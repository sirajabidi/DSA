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
    /*
    // Queue based BFS solution :
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
    
        Queue<List<TreeNode>> queue = new LinkedList<List<TreeNode>>();
        List<TreeNode> firstList = new ArrayList<TreeNode>();
        firstList.add(root);
        queue.add(firstList);

        while(!queue.isEmpty()) {
            List<TreeNode> tmpList = queue.poll();

            List<Integer> forResult = new ArrayList<Integer>();
            List<TreeNode> forQueue = new ArrayList<TreeNode>();
            
            for (TreeNode node : tmpList) {
                forResult.add(node.val);
                if (node.left != null) {
                    forQueue.add(node.left);
                }
                if (node.right != null) {
                    forQueue.add(node.right);
                }                
            }

            if (forQueue.size() > 0) {
                queue.add(forQueue);
            }
            result.add(forResult);
        }
        return result;
    }
    */

    private void _helperLevelOderTraversal(TreeNode root, int level, List<List<Integer>> result) {
         if (root == null) {
             return;
         }

         List<Integer> list = null;
         if (result.size() > level) {
            list = result.get(level);
         } else {
             list = new ArrayList<>();
             result.add(list);
         }

         list.add(root.val);
         _helperLevelOderTraversal(root.left, level + 1, result);
         _helperLevelOderTraversal(root.right, level + 1, result);
     }

     public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<>();
        _helperLevelOderTraversal(root, 0, result);
        return result;
     }

}
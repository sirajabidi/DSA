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

 class BinarySearchTree {
    public TreeNode root = null;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean _insert(TreeNode currentNode, TreeNode nodeToInsert) {
        if (currentNode == null) {
            return false;
        }

        boolean inserted = false;
        if (nodeToInsert.val < currentNode.val) {
            inserted = _insert(currentNode.left, nodeToInsert);
            if (!inserted) {
                currentNode.left = nodeToInsert;
                inserted = true;
            }
        } else {
            inserted = _insert(currentNode.right, nodeToInsert);
            if (!inserted) {
                currentNode.right = nodeToInsert;
                inserted = true;
            }
        }
        return inserted;
    }

    public void insert(int item) {
        TreeNode node  = new TreeNode(item);
        if (this.root == null) {
            this.root = node;
            return;
        }
        _insert(this.root, node);
    }

 }

class Solution {
    public void insertIntoBST(BinarySearchTree tree, int[] nums, int startIndex, int endIndex) {
        System.out.println("startIndex: " + startIndex);
        System.out.println("endIndex: " + endIndex);

        if (startIndex > endIndex) {
            System.out.println("Returning");
            return;
        }

        int middleIndex = (startIndex + endIndex)/2;
        System.out.println("middleIndex: " + middleIndex);
        int item = nums[middleIndex];
        System.out.println("inserting: " + item);
        tree.insert(item);
        insertIntoBST(tree, nums, startIndex, middleIndex-1);
        insertIntoBST(tree, nums, middleIndex+1, endIndex);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        BinarySearchTree bst = new BinarySearchTree();
        insertIntoBST(bst, nums, 0, (nums.length)-1);
        return bst.root;
    }
}
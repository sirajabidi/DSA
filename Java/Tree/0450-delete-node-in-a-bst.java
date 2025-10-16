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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        boolean deletingRootNode = false;
        if (root.val == key) {
            deletingRootNode = true;
        }

        TreeNode parent = null;
        TreeNode found = root;
        
        while(found != null) {
            if (key > found.val) {
                parent = found;
                found = found.right;
            } else if (key < found.val) {
                parent = found;
                found = found.left;
            } else {
                // node found:
                // Case 1 : (found node has no children both left and right are null):
                if ((found.left == null) && (found.right == null)) {
                    if (deletingRootNode) {
                        root = null;
                        return null;
                    }

                    if ((parent.left != null) && (parent.left.val == found.val)) {
                        parent.left = null;
                        return root;
                    }

                    if ((parent.right != null) && (parent.right.val == found.val)) {
                        parent.right = null;
                        return root;
                    }
                }

                // case 2: found node has right subTree(find inorderSuccessor):
                if (found.right != null) {
                    TreeNode succeessorFound = found.right;
                    parent = found;
                    while(succeessorFound.left != null) {
                        parent = succeessorFound;
                        succeessorFound = succeessorFound.left;
                    }

                    found.val = succeessorFound.val;
                    if ((parent.left != null) && (parent.left.val == succeessorFound.val)) {
                        parent.left = succeessorFound.right;
                        if (deletingRootNode) {
                            return found;
                        }
                        return root;
                    }

                    if ((parent.right != null) && (parent.right.val == succeessorFound.val)) {
                        parent.right = succeessorFound.right;
                        if (deletingRootNode) {
                            return found;
                        }
                        return root;
                    }
                }

                // case 3: found node has leftSubtree(find inorderPredeccesor):
                if (found.left != null) {
                    TreeNode predecesssorFound = found.left;
                    parent = found;
                    while(predecesssorFound.right != null) {
                        parent = predecesssorFound;
                        predecesssorFound = predecesssorFound.right;
                    }

                    found.val = predecesssorFound.val;
                    if ((parent.left != null) && (parent.left.val == predecesssorFound.val)) {
                        parent.left = predecesssorFound.left;
                        if (deletingRootNode) {
                            return found;
                        }
                        return root;
                    }

                    if ((parent.right != null) && (parent.right.val == predecesssorFound.val)) {
                        parent.right = predecesssorFound.left;
                        if (deletingRootNode) {
                            return found;
                        }
                        return root;
                    }
                }
            }
        }
        return root;
    }
}
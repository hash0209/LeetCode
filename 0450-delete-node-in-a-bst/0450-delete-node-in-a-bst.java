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

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {

            if (curr.val == key) {
                if (prev == null) {
                    if (curr.left == null) {
                        root = curr.right;
                    } else {
                        root = curr.left;
                        TreeNode temp = curr.left;
                        while (temp.right != null) {
                            temp = temp.right;
                        }

                        temp.right = curr.right;

                    }
                }

                else {
                    if (curr.left == null) {
                        if (prev.val > curr.val) {
                            prev.left = curr.right;
                        } else {
                            prev.right = curr.right;
                        }
                    } else {
                        TreeNode temp = curr.left;
                        if (prev.val > curr.val) {
                            prev.left = temp;
                        } else {
                            prev.right = temp;
                        }

                        while (temp.right != null) {
                            temp = temp.right;
                        }

                        temp.right = curr.right;

                    }
                }

                curr.left = null;
                curr.right =null;

                break ;
            } else {

                prev = curr;
                if (curr.val > key) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

        }

        return root;

    }
}
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
    public void recoverTree(TreeNode root) {

        TreeNode prev = null;

        Stack<TreeNode> s = new Stack<>();

        TreeNode n1 = null;
        TreeNode n2 = null;

        TreeNode curr = root;

        while (true) {

            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            else {
                if (s.isEmpty()) {
                    break;
                }

                curr = s.pop();

                if (prev != null && curr.val < prev.val) {
                    if (n1 == null) {
                        n1 = prev;
                        n2 = curr;
                    } else {
                        n2 = curr;
                        break;
                    }
                }

                prev = curr;
                curr = curr.right;

            }

        }

        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

    }
}
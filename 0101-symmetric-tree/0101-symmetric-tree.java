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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return check(root.left , root.right);
    }


    public boolean check(TreeNode n1 , TreeNode n2){

        if(n1 == null || n2 ==null){
           if(n1 == null && n2 == null){
            return true;
           }
           return false;
        }

        


        boolean ans1 = check(n1.left ,n2.right);
        boolean ans2 = check(n1.right ,n2.left);
        boolean ans3 = n1.val == n2.val;

         return ans3 && ans1 && ans2;

    }
}
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
    public boolean isValidBST(TreeNode root) {

       if(root == null){
        return true ; 
       }

        if(root.left != null){
           
           if(root.val <= root.left.val ){
            return false;
           }

            TreeNode temp = root.left.right;


            while(temp!=null && temp.right!=null){
                temp = temp.right;
            }

            if(temp!=null && temp.val >= root.val){
                return false;
            }

        }


        if(root.right != null){
           
           if(root.val >= root.right.val ){
            return false;
           }

            TreeNode temp = root.right.left;


            while(temp!=null && temp.left!=null){
                temp = temp.left;
            }

            if(temp != null && temp.val <= root.val){
                return false;
            }

        }


        return isValidBST(root.left) && isValidBST(root.right);
        
    }
}
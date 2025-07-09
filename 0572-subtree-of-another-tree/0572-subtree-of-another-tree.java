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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) { //nul , null true
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }
        

        boolean ans = false;
        if (root.val == subRoot.val) { 
            ans = check(root ,subRoot); 
         } 
       if(!ans){
            ans =  isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); //4 ,4

        }
        return ans;

    }

    public boolean check(TreeNode n1 , TreeNode n2){

        if(n1 == null && n2 == null){
            return true;
        }
        if(n1 == null || n2 == null){
            return false;
        }
         if(n1.val  != n2.val){
            return false;
        }

        return check(n1.left , n2.left)  && check(n1.right , n2.right) ;

    }


    
}
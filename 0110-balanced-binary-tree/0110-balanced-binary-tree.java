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
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }
        int l = find(root.left);
        int r = find(root.right);


        if(l ==-1 || r== -1){
            return false;
        }

        int diff = Math.abs(l-r);
        if(diff >1){
            return false;
        }
        return true;
        
        
        
    }

    public int find(TreeNode n){
        if(n == null){
            return 0;
        }

        int l = find(n.left);
        int r = find(n.right);


        if(l ==-1 || r== -1){
            return -1;
        }

        int diff = Math.abs(l-r);
        if(diff >1){
            return -1;
        }

        return 1 + Math.max(l,r) ;
    }
}
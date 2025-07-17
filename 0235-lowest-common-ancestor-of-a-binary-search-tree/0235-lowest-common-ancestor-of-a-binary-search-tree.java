/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        if(root == null || root ==p || root ==q){
            return root;
        }


        if(p.val < root.val && q.val < root.val){
          return    lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){
          return   lowestCommonAncestor(root.right, p, q);
        }
        else{
          TreeNode left =   lowestCommonAncestor(root.left, p, q);
          TreeNode right =  lowestCommonAncestor(root.right, p, q);

           if(left == null){
            return right;
           }
           else if (right == null){
            return left;
           }
           else{
            return root;
           }
        }
        
            
        
        
    }
}
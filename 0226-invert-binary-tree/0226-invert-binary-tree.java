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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;

    }


    public void  invert (TreeNode n){

        if(n== null){
            return ;
        }
          

           TreeNode left = n.left;
           TreeNode right = n.right;

           TreeNode temp = left ;
           n.left = right;
           n.right = temp;


           invert(n.left);
           invert(n.right);

                 


            



    }
}
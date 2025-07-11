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
    public int countNodes(TreeNode root) {

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if(lh == rh){
            return (int) Math.pow(2,lh)-1;
           
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }



        
        
    }


    public int leftHeight(TreeNode root){
        int count =0;
        while(root!=null){
            root=root.left;
            count++;
        }
        return count;
    }

        public int rightHeight(TreeNode root){
        int count =0;
        while(root!=null){
            root=root.right;
            count++;
        }
        return count;
    }
}
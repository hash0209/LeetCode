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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode n = new TreeNode(val);

        if(root == null){
            return n;
        }


        TreeNode prev = null;

        
        TreeNode curr = root;

        while(curr!=null){
            prev = curr;
            if(curr.val > val){
                
                curr = curr.left ;
            }
            else{
                curr = curr.right;
            }
        }

        if(prev.val > val){
            prev.left =  n;
        }
        else{
            prev.right =n;
        }

        return root;
        
    }
}
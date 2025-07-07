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
    public int maxPathSum(TreeNode root) {

        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        find(root , ans);
        return ans[0];

    }

    public int find(TreeNode root , int[] ans){
        if(root == null){
            return 0;
        }

        int left = find(root.left , ans);
        int right = find(root.right , ans);

        int total = root.val ; 
        total = Math.max(total , total + left );
        total = Math.max(total , total + right);

        ans[0] = Math.max(ans[0], total);

        int totalLeft = Math.max(root.val , root.val+left);
        int totalRight = Math.max(root.val , root.val + right);

        

      

        return Math.max(totalLeft , totalRight);
    }
}
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];

        find(root , max);
        return max[0];
    }

    public int find(TreeNode root , int[] max){
          if(root == null){
            return 0;
          }    


          int left = find(root.left , max);
          int right = find(root.right , max);

          max[0] = Math.max(left+right , max[0]);
          return 1 + Math.max(left , right);
    }
}
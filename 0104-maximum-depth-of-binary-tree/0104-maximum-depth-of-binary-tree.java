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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int count =0;
         if(root == null){
            return 0;
         }
         q.add(root);

         while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i =0; i < size ; i++){
                TreeNode temp = q.poll();
                if(null != temp.left){
                    q.add(temp.left);
                }
                if(null!=temp.right){
                    q.add(temp.right);
                }
            }
         }

         return count;


    }
}
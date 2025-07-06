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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i =0 ; i < size;i++){
                TreeNode n = q.poll();
                l.add(n.val);
                if(null !=n.left){
                q.add(n.left);
                }
                if(null!=n.right){
                q.add(n.right);
                }


            }
            ans.add(l);
        }
        return ans;
        
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

          Queue<TreeNode> q = new LinkedList<>();

          q.add(root);

          int level = 1;

          while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i =0; i < size ; i++){
                    TreeNode n = q.poll();
                    l.add(n.val);
                    if(n.left!=null){
                        q.add(n.left);
                    }
                    if(n.right!=null){
                        q.add(n.right);
                    }
            }

            if(level%2 == 0){
                Collections.reverse(l);
            }
            res.add(l);
            level++;


          }
          return res;


        
    }
}
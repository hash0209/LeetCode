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
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;

        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
             int size = q.size();
             List<Integer> l = new ArrayList<Integer>();

           
                for(int i =0 ; i < size ; i++){
                    TreeNode curr = q.poll();
                    l.add(curr.val);
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                }
             if(level%2 == 0){
             ans.add(l);
             }
             else{
                Collections.reverse(l);
                ans.add(l);
             }

             level++;
        }

        return ans;
    }
}
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
             LinkedList<Integer> l = new LinkedList<Integer>();

           
                for(int i =0 ; i < size ; i++){
                    TreeNode curr = q.poll();
                   // l.add(curr.val);
                   if(level%2 == 0){
                    l.addFirst(curr.val);
                   }
                   else{
                    l.addLast(curr.val);
                   }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
           
             ans.add(l);       
             level++;
        }

        return ans;
    }
}
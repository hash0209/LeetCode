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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recurrse(root , 0 ,ans);
        return ans;

    }

    public void recurrse(TreeNode root , int depth , List<Integer> list){
           if(root == null){
            return;
           }

           if(depth == list.size()){
            list.add(root.val);
           }

           recurrse(root.right ,depth+1 , list);
           recurrse(root.left , depth +1 , list);
    }
}
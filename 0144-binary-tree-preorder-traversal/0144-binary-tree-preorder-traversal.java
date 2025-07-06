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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();
        return find(root , ans);

        
        
    }


    public List<Integer> find(TreeNode root , List<Integer> ans ){

        if(root == null){
                 return ans;
        }

        ans.add(root.val);
        find(root.left , ans);
        find(root.right , ans);

        return ans;

        
    }
}
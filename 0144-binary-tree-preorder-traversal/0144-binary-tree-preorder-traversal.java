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
        if(root == null){
            return ans;
        }


        while(root != null){
          

            if(root.left!=null){
                TreeNode temp = root.left ;

                while(temp.right !=null && temp.right != root){
                    temp = temp.right;
                }
                if(temp.right==null){
                    temp.right = root;
                     ans.add(root.val);
                    root = root.left;
                }
                else{
                     temp.right = null;
                     root=root.right;
                }
            }
            else{
                ans.add(root.val);
                root = root.right;
            }
        }

        return ans;
        
    }
}
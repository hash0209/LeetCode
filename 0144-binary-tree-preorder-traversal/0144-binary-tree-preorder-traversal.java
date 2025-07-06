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

        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode root1 = st.pop();

            ans.add(root1.val);
            if(root1.right!=null){
                st.push(root1.right);
            }
             if(root1.left!=null){
                st.push(root1.left);
            }
        }

        return ans;
        
    }
}
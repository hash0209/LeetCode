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
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> ans = new ArrayList<>();
          if(root == null){
            return ans;
          }

          Stack<TreeNode> st = new Stack<>();
           while(root != null){
            st.push(root);
            root = root.left;
           }

          while(!st.isEmpty()){
            TreeNode n = st.pop();
            ans.add(n.val);

            if(n.right != null){
                n=n.right;
                st.push(n);
                n =n.left;
                while(n!=null){
                    st.push(n);
                    n=n.left;

                }

            }
          }
          return ans;
    }
}
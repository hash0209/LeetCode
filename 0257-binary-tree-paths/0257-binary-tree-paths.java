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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        dfs(root,s,ans);
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder path, List<String> ans) {


        if(root == null){
            return;
        }

       

      //  path += (path.length() > 0 ? "->" : "") + root.val;
        if(path.length() > 0){
            path.append("->");
        }

        path.append(root.val);

        int len = path.length();

        if(root.left == null && root.right ==null){
            ans.add(path.toString());
            return ;
        }

        dfs(root.left,path,ans);
        path.setLength(len);
        dfs(root.right,path,ans);





    }

}
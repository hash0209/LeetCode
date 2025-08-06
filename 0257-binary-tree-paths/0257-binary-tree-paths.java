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
        List<String> list = new ArrayList<>();
        find(root,new StringBuilder() ,list);
        return list;
    }

    public void find(TreeNode root , StringBuilder path , List<String> res){
        if(root == null){
            return ;
        }

        

        if(path.isEmpty()){
            path.append(root.val);
        }
        else{
            path.append("->" + root.val);
        }

        if(root.left == null && root.right == null){
            res.add(path.toString());
            return;
        }

        int len = path.length();

        find(root.left ,path ,  res);
        path.setLength(len);
        find(root.right,path , res);


    }
}
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
        return find(root , new ArrayList<Integer>());
    }

    public List<Integer> find(TreeNode root , List<Integer> list){
                 if(root == null){
                    return list;
                 }  

                 find(root.left ,list);
                 list.add(root.val);
                 find(root.right , list);

                 return list;  
    }
}
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return find(preorder , new int[1] , Integer.MAX_VALUE);
    }


    public TreeNode find(int[] preorder , int[] idx ,int ub ){
        if(idx[0] >= preorder.length || preorder[idx[0]]>= ub){
            return null;
        }

        int val = preorder[idx[0]];

        TreeNode n = new TreeNode(val);


        idx[0]++;

        n.left = find(preorder , idx , val);
        n.right = find(preorder , idx , ub);

        return n;


    }
}
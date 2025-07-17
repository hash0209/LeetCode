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

              return construct(preorder , 0 , preorder.length-1);
        
    }


    public TreeNode construct(int[] preorder , int preStart , int preEnd ){
        if(preStart > preEnd){
            return null;
        }


        TreeNode n = new TreeNode(preorder[preStart]);


        int root = preorder[preStart];


        int idx = preStart+1;

        while(idx <= preEnd){
            if(root < preorder[idx]){
                break;
            }
            idx++;
        }

        n.left  = construct(preorder,preStart+1,idx-1);
        n.right = construct(preorder,idx , preEnd);


        return n ;




        



    }
}
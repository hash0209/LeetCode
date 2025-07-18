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
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        Map<Integer,Integer> map = new HashMap<>();
        int idx =0;

        while(idx < inorder.length){
            map.put(inorder[idx] , idx);
            idx ++;
        }
        return build(0,preorder.length-1 , 0 , inorder.length-1 , preorder , map);
        
    }

    public TreeNode build(int preStart , int preEnd , int inStart , int inEnd , int[] preorder , Map<Integer,Integer> map ){
                    if(preStart > preEnd || inStart > inEnd){
                        return null;
                    }

                    TreeNode root = new TreeNode(preorder[preStart]);


                    int inRoot = map.get(preorder[preStart]);
                    int nums = inRoot-inStart;


                  root.left =  build(preStart+1,preStart+nums,inStart , inRoot-1,preorder, map);
                  root.right =   build(preStart+nums+1 , preEnd , inRoot+1,inEnd , preorder , map);
                  return root;
    }
}
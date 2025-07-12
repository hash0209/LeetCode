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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer , Integer> map = new HashMap<>();
        int idx =0;

        while(idx  < inorder.length){
            map.put(inorder[idx],idx);
            idx++;
        }
       return build(0,postorder.length-1 , 0 , inorder.length-1 , postorder, map);


    }

    public TreeNode build(int postStart , int postEnd , int inStart , int inEnd , int[] postorder ,  Map<Integer , Integer> map){
               
               if(postStart > postEnd || inStart > inEnd){
                return null;

               }

               TreeNode root = new TreeNode(postorder[postEnd]);


               int inRoot = map.get(postorder[postEnd]);

               int nums = inRoot-inStart;

              root.left = build(postStart , postStart+nums-1,inStart , inRoot-1 , postorder , map);
              root.right =  build(postStart+nums,postEnd-1,inRoot+1,inEnd , postorder , map);

              return root;


    }



}
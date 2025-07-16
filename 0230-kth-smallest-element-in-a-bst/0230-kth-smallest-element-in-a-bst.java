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
    public int kthSmallest(TreeNode root, int k) {


        TreeNode curr = root ; 
        Stack<TreeNode> s = new Stack<>();

        int idx =0 ; 

        while(true){
            if(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            else{
                if(s.isEmpty()){
                    break;
                }

                curr = s.pop();
                idx ++;
                if(idx == k){
                    break;
                }

                curr =curr.right;
            }
        }


        if(curr != null){
            return curr.val;
        }

        return -1;

        
    }
}
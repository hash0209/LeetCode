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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2= new Stack<>();

        st1.push(p);
        st2.push(q);

        while(!st1.isEmpty() && !st2.isEmpty()){
             p = st1.pop();
             q = st2.pop();

             if(null == p && null == q){
                continue;
             }

            if((null == p && null!= q) ||(null!=p && null ==q) ){
                return false;
            }

            
            if(p.val != q.val){
                return false;
            }

            st1.push(p.right);
            st2.push(q.right);

            st1.push(p.left);
            st2.push(q.left);
        }


        if(st1.isEmpty() && st2.isEmpty()){
            return true;
        }

        return false;
    }
}
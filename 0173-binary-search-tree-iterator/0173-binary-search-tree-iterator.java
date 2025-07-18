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
class BSTIterator {

    Stack<TreeNode> s = new Stack<>();

    TreeNode curr = null;

    public BSTIterator(TreeNode root) {

        curr = root;

        while(curr!=null){
           
            s.push(curr);
            curr=curr.left;


        }
    
        

        
    }
    
    public int next() {
        curr = s.pop();
        int val = curr.val;
        curr = curr.right;
        while(curr!=null){
            s.push(curr);
            curr=curr.left;
        }
        

       
        return val ;


    }
    
    public boolean hasNext() {
      if(s.isEmpty()){
        return false;
      }
      return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
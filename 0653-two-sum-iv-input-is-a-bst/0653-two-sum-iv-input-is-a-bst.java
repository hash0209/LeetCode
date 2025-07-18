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
    public boolean findTarget(TreeNode root, int k) {


        Bsit it = new Bsit(root , false);
        Bsit it2 = new Bsit(root,  true);


        int left = it.next() ;
        int right = it2.next();

        while(left < right){
            int sum = left +right;
            if(sum ==k){
                return true;
            }
            else if (sum > k ){
               right =  it2.next();    
            }
            else{
               left = it.next();
            }
          }

          return false;

    }
}

class Bsit {

    Stack<TreeNode> s;

    Boolean rev ;

    

    public Bsit(TreeNode root, boolean reverse) {

        rev = reverse;

        s = new Stack<>();
        pushAll(root , reverse);

    }

    public int next(){

         TreeNode  curr = s.pop();
         int val = curr.val;
         if(rev){
            pushAll(curr.left , rev); 
         }
         else{
         pushAll(curr.right , rev);
         }
         return val;



    }

    public void pushAll(TreeNode root , boolean reverse){

       
            while(root!=null){
                s.push(root);
                if(reverse){
                root = root.right;
                }
                else{
                    root = root.left;
                }
            }
        }

    }

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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }

     

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()){
            int size = q.size();
            int x =0;

            for(int i =0; i < size ; i++){
             //   Node node = q.poll();
                TreeNode n =q.poll();
              //  int level = node.level;
               // map.put(level,n.val);
                x = n.val;

                if(n.left!=null){
                    q.add(n.left );
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }

            l.add(x);
        }


        

        return l;
    }
}


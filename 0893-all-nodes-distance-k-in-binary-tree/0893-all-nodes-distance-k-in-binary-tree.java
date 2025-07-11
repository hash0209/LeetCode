/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<Integer>();
        if(root == null || target == null){
            return ans;
        }


        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,TreeNode> m = new HashMap<>();
        m.put(root,null);
     


        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0 ; i < size ; i++ ){
               TreeNode n = q.poll();

               if(null!=n.left){
                  q.add(n.left);
                  m.put(n.left , n);
               }

               if(null!=n.right){
                  q.add(n.right);
                  m.put(n.right , n);
               }
             
            }
        }


        //int[] arr = new int[501];
        Map<TreeNode , Integer> vm = new HashMap<>();
        q.add(target);
        vm.put(target , 1);
        int d =0;


        while(!q.isEmpty() && d < k  ){
            int size = q.size();

            for(int i =0 ; i < size ; i++){
                 TreeNode curr = q.poll();


                 if(null!= curr.left && !vm.containsKey(curr.left)){
                    q.add(curr.left);
                    vm.put(curr.left,1);
                   
                 }
                 if(null!= curr.right && !vm.containsKey(curr.right)){
                    q.add(curr.right);
                    vm.put(curr.right,1);
                 }

                 TreeNode parent = m.get(curr);

                 if(null!= parent && !vm.containsKey(parent)){
                    q.add(parent);
                    vm.put(parent,1);
                 }
                 
            }
            d++;


        }
 

        while (!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;



        




        
        
    }
}
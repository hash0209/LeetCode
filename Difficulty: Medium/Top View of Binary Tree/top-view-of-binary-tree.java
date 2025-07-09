/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    
  
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> l = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        
        
        TreeNode curr = new TreeNode(root , 0);
        
        Map<Integer , Integer> vmap = new TreeMap<Integer , Integer>();
        
        
        q.add(curr);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0; i < size ; i++){
                curr = q.poll();
                
                Node n = curr.node;
                int v = curr.vertical;
                
                if(!vmap.containsKey(v)){
                    vmap.put(v,n.data);
                }
                
                if(n.left!=null){
                    q.add(new TreeNode(n.left, v-1 ));
                }
                if(n.right!=null){
                    q.add(new TreeNode(n.right , v+1));
                }
                
                
                
                
            }
        }
        
        for(Integer x : vmap.values()){
            l.add(x);
        }
        
        return l;
        
        
        
    }
}

  class TreeNode{
        Node node;
        int vertical ;
        
        TreeNode(){
            
        }
        
        TreeNode(Node node , int vertical){
            this.node =node;
            this.vertical = vertical;
        }
        
        
    }
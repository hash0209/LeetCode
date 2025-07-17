/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        Node predN = null;
        
        Node succN = null;
        
        int pred = Integer.MIN_VALUE;
        int succ = Integer.MAX_VALUE;
        
        
        while(!q.isEmpty()){
            
            int size =q.size();
            
            for(int i =0; i < size; i++){
                  Node n = q.poll();
                  
                  if(n.data < key){
                     if(n.data > pred){
                         pred = n.data;
                         predN = n;
                     }
                      
                  }
                  if(n.data > key){
                       if(n.data <  succ){
                         succ = n.data;
                         succN = n;
                     }
                  }
                  
                  
                  if(null!=n.left){
                      q.add(n.left);
                  }
                  if(null!=n.right){
                      q.add(n.right);
                  }
            }
            
            
        }
        
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(predN);
        list.add(succN);
        
        
       return list;
        
        
        
        
        
    }
    
    
   
}
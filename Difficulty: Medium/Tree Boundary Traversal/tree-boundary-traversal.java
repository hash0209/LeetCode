/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(node == null){
            return l ;
        }
        
        l.add(node.data);
        
        if(node.left == null && node.right == null ){
           return l;
        }
        
        if(node.left != null){
            findL(node.left , l);
        }
        
        
        Node curr = node ;
        Stack<Node> s = new Stack<>();
       // s.push(curr);
        
        
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
                if(curr.right == null && curr.left == null){
                    l.add(curr.data);
                }
                curr=curr.right;
            }
            }
        
        
        
        if(node.right!=null){
             findR( node.right, l );
        }
        
        return l ;
    }
    
        public void findR(Node curr, ArrayList<Integer> l ){
        if(curr == null){
            return ;
        }
        if(curr.left == null && curr.right == null){
            return ;
        }
        
       
        
        if(curr.right!=null){
            findR(curr.right , l);
        }
        else{
            findR(curr.left,l);
        }
         l.add(curr.data);
    }
    
    
    
    public void findL(Node curr, ArrayList<Integer> l ){
        if(curr == null){
            return ;
        }
        if(curr.left == null && curr.right == null){
            return ;
        }
        
        l.add(curr.data);
        
        if(curr.left!=null){
            findL(curr.left , l);
        }
        else{
            findL(curr.right,l);
        }
    }
}
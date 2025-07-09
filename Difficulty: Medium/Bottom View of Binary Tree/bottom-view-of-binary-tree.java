/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> l = new ArrayList<Integer>();
        TreeMap<Integer,Integer> vmap= new TreeMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(new TreeNode(root,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0; i < size ;i++){
                TreeNode curr = q.poll();
                Node n = curr.node;
                int v = curr.vertical;
                
                vmap.put(v , n.data);
                
                
                if(n.left!=null){
                    q.add(new TreeNode(n.left,v-1));                
                    
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
    Node node ;
    int vertical ;
    
    TreeNode(){
        
    }
    
    TreeNode(Node node , int vertical){
        this.node = node ;
        this.vertical =vertical;
    }
}
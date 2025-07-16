/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
    int findCeil(Node root, int key) {
        // code here
        
        int ans  = Integer.MAX_VALUE;
        
        while(root != null){
            if(root.data == key){
                return key;
            }
            if(root.data > key){
                ans=Math.min(ans,root.data);
                root = root.left;
                
            }
            else{
                root = root.right;
            }
        }
        
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        
        
        
        
    }
}
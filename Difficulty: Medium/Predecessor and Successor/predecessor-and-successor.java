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
        
        Node succN = null;
        int succ = Integer.MAX_VALUE;
        
        Node curr = root;
        
        while(curr != null){
            if(curr.data <= key ){
                curr = curr.right;
            }
            else{
                if(curr.data < succ){
                    succ = curr.data;
                    succN = curr;
                    
                }
                curr = curr.left;
        }
        
        
        
    }
    
    curr = root;
    
    
    Node predN = null;
    int pred =  Integer.MIN_VALUE;
    
    
        
        while(curr != null){
            if(curr.data >=  key ){
                curr = curr.left;
            }
            else{
                if(curr.data > pred){
                    pred = curr.data;
                    predN = curr;
                    
                }
                curr = curr.right;
        }
        
        
        
    }
    
    ArrayList<Node> ans = new ArrayList<>();
    ans.add(predN);
    ans.add(succN);
    return ans;
    }
    
    
   
}
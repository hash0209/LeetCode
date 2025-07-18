// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        
        
        return find(root).size;
        
        
    }
    
    
    static BST find(Node root){
        
        if(root == null){
            return new BST(0,Integer.MAX_VALUE , Integer.MIN_VALUE);
        }
        
        BST left = find(root.left);
        BST right = find(root.right);
        
        
        if(root.data > left.large && root.data < right.small){
            return new BST(1+left.size+right.size , Math.min(root.data , left.small),Math.max(root.data,right.large));
        }
        
        return new BST(Math.max(left.size,right.size) , Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    
    
    
   
}


class BST {
    int size ;
    int small;
    int large;
    
    
    public BST(int size , int small , int large){
        this.size = size;
        this.small = small;
        this.large =large;
        
    }
}
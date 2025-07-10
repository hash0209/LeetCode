/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        
        if(root == null){
            return 1;
        }
        
        if(root.left ==null & root.right == null){
            return 1;
        }
        
        int sum = 0;
        
        if(null != root.left){
            sum = sum + root.left.data;
        }
        if(null !=root.right){
            sum = sum + root.right.data;
        }
        
        if(sum != root.data){
            return 0;
        }
        
        int x = isSumProperty(root.left);
        int y = isSumProperty(root.right);
        
        if(x == 0 || y ==0){
            return 0;
        }else{
            return 1;
        }
    }
}
// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        
        int ans = Integer.MIN_VALUE; 
        
        while(root !=null){
            if(root.data ==x){
                return x;
            }
            
            if(root.data > x){
                
                root=root.left;
            }
            else{
                ans = Math.max(root.data , ans);
                root=root.right;
            }
        }
        
      if(ans == Integer.MIN_VALUE){
          return -1;
      }
      
      return ans;
        
    }
}
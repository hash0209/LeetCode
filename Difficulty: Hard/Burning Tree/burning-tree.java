/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        
        int ans =0;
        
        
        if(root == null){
            return ans;
        }
        
        Node t = null;
        
        
        Queue<Node> q = new LinkedList<>();
        Map<Node,Node> m = new HashMap<>();
        
        m.put(root,null);
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0; i < size ; i++){
                Node curr = q.poll();
                if(curr.data == target){
                    t = curr;
                }
                
                if(null != curr.left){
                    m.put(curr.left , curr);
                    q.add(curr.left);
                }
                
                if(null!= curr.right){
                    m.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
        }
        
       
        
      
        
        
        q.add(t);
        Map<Node,Integer> vm = new HashMap<>();
        vm.put(t,1);
        ans =-1;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0; i < size ; i++){
                
                Node curr = q.poll();
                
                if(null!=curr.left && !vm.containsKey(curr.left)){
                    q.add(curr.left);
                    vm.put(curr.left,1);
                }
                   if(null!=curr.right && !vm.containsKey(curr.right)){
                    q.add(curr.right);
                    vm.put(curr.right,1);
                }
                
                Node parent = m.get(curr);
                if(null != parent && !vm.containsKey(parent)){
                    q.add(parent);
                    vm.put(parent,1);
                }
                  
                
                
                
                
            }
            
            ans++;
        }
        
        return ans;
        
        
        
    }
}
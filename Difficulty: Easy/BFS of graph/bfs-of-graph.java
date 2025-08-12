class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] visited =new boolean[adj.size()];
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            
            int size = q.size();
           
            
            for(int i = 0; i < size ; i++){
                
                int n = q.poll();
               
               // visited[n] =true;
                ans.add(n);
                
                List<Integer> nb = adj.get(n);
                
                
                for(Integer j : nb){
                    
                   
                    if(!visited[j]){
                        q.add(j);
                        visited[j] =true;
                    }
                }
                
            }
            
             
        }
        
        return ans;
    }
}
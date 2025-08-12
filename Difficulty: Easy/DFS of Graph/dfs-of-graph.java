class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> res = new ArrayList<>();
        // Code here
        boolean[] visited =new boolean[adj.size()];
        
        dfs(adj , 0,visited , res);
        
        return res;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , int n , boolean[] visited , ArrayList<Integer> res){
           
           res.add(n);
           visited[n] =true;
           
           for(Integer nb : adj.get(n)){
               if(!visited[nb]){
                   dfs(adj , nb, visited , res);
               }
           }
    }
}
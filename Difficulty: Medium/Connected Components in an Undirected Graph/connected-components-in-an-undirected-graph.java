
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> adj = build(V , edges);
        
        for(int n =0; n < adj.size() ; n ++){
            if(!visited[n]){
                ArrayList<Integer> list = new ArrayList<>();
                find(n,visited , adj , list);
                ans.add(list);
                
            }
        }
        
        return ans;
        
        
        
        
    }
    
    public void find(int n , boolean[] visited , ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> ans   ){
        
       
        visited[n] =true;
        ans.add(n);
        
        for(Integer nb :adj.get(n)){
            if(!visited[nb]){
                find(nb , visited , adj , ans);
            }
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> build(int V , int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
          for(int i =0; i < V ; i++){
              adj.add(new ArrayList<>());
          }
          
          
          for(int i = 0; i < edges.length ; i++){
                 int u = edges[i][0];
                 int v = edges[i][1];
                 
                 adj.get(u).add(v);
                 adj.get(v).add(u);
          }
          
          return adj ;
        
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int ans = 0;

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        List<List<Integer>> adj  =  build(isConnected);

        for (int i = 0; i < adj.size(); i++) {

            if (!visited[i]) {
                ans++;
                dfs(i, adj, visited);

            }
        }

        return ans;

    }

    public void dfs(int i,  List<List<Integer>> adj , boolean[] visited) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int nb : adj.get(i)) {
            
                dfs(nb, adj, visited);
            
        }
    }

    public List<List<Integer>> build(int[][] mat){
          List<List<Integer>> adj = new ArrayList<>();

          
          for(int i = 0; i < mat.length ; i++){
            
            List<Integer> list = new ArrayList<>();
            for(int j =0; j < mat.length ; j ++){
                if(i!=j && mat[i][j] == 1){
                    list.add(j);
                }
            }
            adj.add(list);


          }
          return adj;

          
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int ans = 0;

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for(int i =0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(!visited[i]){
                    ans ++;
                     dfs(i,isConnected,visited);
                     
                }
            }
        }

        return ans;
        
    }



    public void dfs (int i , int[][] mat , boolean[] visited){
           if(visited[i]){
            return ;
           }

          

           visited[i] = true;

           

           for(int j =0; j < mat[i].length ; j ++){
              if(  i!=j && mat[i][j] ==1){
                dfs (j , mat , visited);
              }
           }
    }
}
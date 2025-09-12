class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length-1;
        int m = grid[0].length-1;

        int ans =0;

        boolean[][] visited =new boolean[ grid.length][ grid[0].length];

        for(int i =0; i <= n ; i++){
            for(int j =0; j <= m ; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                if(!visited[i][j]){
                    ans++;
                    find(i, j , grid,visited);
                }


            }
    }
    return ans;      
    }


    public void find(int row , int col , char[][] grid , boolean[][] visited){
               if(row < 0 || row == grid.length || col <0 || col == grid[0].length){
                   return;
               }

               if(grid[row][col]=='0' || visited[row][col]){
                return;
               }

               visited[row][col] = true;

               find(row+1 , col , grid , visited);
               find(row-1,col , grid,visited);
               find(row , col+1,grid,visited);
               find(row , col-1,grid,visited);




    }
}
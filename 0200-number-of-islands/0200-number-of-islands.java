class Solution {
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int count=0;


        for(int r =0; r < row ; r++){

            for(int c= 0; c < col ; c++){

                if(!visited[r][c] && grid[r][c]== '1'){
                    findIsland(r,c,grid ,visited);
                    count++;
                }
            }
        }

          return count;
        
    }

    public void findIsland(int r , int c , char[][] grid , boolean[][] visited){
          if(r < 0 || c <  0|| r >= grid.length || c >= grid[0].length){
            return ;
          }

          if(visited[r][c] || grid[r][c] == '0'){
            return ;
          }

          visited[r][c] =true;
          findIsland(r+1 , c , grid ,visited);
          findIsland(r-1,c,grid  ,visited);
          findIsland(r , c+1 , grid ,visited);
          findIsland(r , c-1 , grid ,visited);

    }
}
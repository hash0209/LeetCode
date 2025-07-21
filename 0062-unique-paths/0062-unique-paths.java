class Solution {
    public int uniquePaths(int m, int n) {


        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return find(m-1 , n-1 , dp);


    }



    public int find( int r , int c , int [][] dp){
        if( r == 0 && c == 0){
            return 1;
        }

        if(r < 0 || c < 0){
            return 0 ;
        }


        if(dp[r][c]!=-1){
            return dp[r][c];
        }

       


        
          int up = find(r-1 , c , dp);
        

        

       
          int left = find( r, c-1 , dp);
        

        return dp[r][c] = up + left;
         
    }



}
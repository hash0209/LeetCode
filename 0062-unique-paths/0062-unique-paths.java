class Solution {
    public int uniquePaths(int m, int n) {


        int[][] dp = new int[m][n];

        dp[0][0]= 1; 

        int ans = 0;

        for (int r  = 0; r < m ; r ++){
            for(int c = 0 ; c < n ; c ++){

                if( r== 0 && c == 0){
                    continue ;
                }
                  
                  int up = 0 ;
                  if( r -1 >= 0){
                    up =  dp[r-1][c];
                  }

                  int down = 0;
                  if(c-1>=0){
                     down = dp[r][c-1];
                  }

                  dp[r][c] = up+down;

            }
        }

       return dp[m-1][n-1];

    }





}
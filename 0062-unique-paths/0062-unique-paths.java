class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        dp[0][0] =1;

        for(int x =0 ; x < m ; x++){
            for(int y =0; y < n ; y++){
                if(x== 0 && y== 0){
                    continue;
                }

                int up = x-1 >= 0 ? dp[x-1][y] : 0;
                int left = y-1 >= 0 ? dp[x][y-1] : 0;

                dp[x][y] =up+left;
            }
        }
        return dp[m-1][n-1];
    }

  
}
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length ; 
        int n = matrix[0].length ;

        int[][] dp = new int[m][n];

        for(int i = 0;  i < n ; i++){
            dp[0][i] = matrix[0][i];
        }
        

        for(int i = 1 ; i < m ; i++){

            for(int j =0; j < n ; j ++){

                int up =     dp[i-1][j];
                int left =(j-1 >= 0) ?   dp[i-1][j-1] :  Integer.MAX_VALUE;
                int right =(j+1 < n ) ?  dp[i-1][j+1] : Integer.MAX_VALUE ; 

                int ans = Math.min(left , right);

                ans = Math.min(ans , up);

                dp[i][j] = ans + matrix[i][j];
                
                            }
        }


        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n ; i++){
            ans = Math.min(dp[m-1][i],ans);
        }
        return ans;
    }
}
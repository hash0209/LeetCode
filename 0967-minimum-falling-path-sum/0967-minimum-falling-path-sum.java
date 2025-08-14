class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length ; 
        int n = matrix[0].length ;

        int[] dp = new int[n];

        for(int i = 0;  i < n ; i++){
            dp[i] = matrix[0][i];
        }
        

        for(int i = 1 ; i < m ; i++){

            int[] temp = new int[n];

            for(int j =0; j < n ; j ++){

                int up =     dp[j];
                int left =(j-1 >= 0) ?   dp[j-1] :  Integer.MAX_VALUE;
                int right =(j+1 < n ) ?  dp[j+1] : Integer.MAX_VALUE ; 

                int ans = Math.min(left , right);

                ans = Math.min(ans , up);

                temp[j] = ans + matrix[i][j];
                
                            }
                            dp = temp;
        }


        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n ; i++){
            ans = Math.min(dp[i],ans);
        }
        return ans;
    }
}
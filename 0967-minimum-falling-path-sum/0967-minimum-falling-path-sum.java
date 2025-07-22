class Solution {
    public int minFallingPathSum(int[][] matrix) {


        int ans = Integer.MAX_VALUE ;
        int[][] dp = new int[matrix.length][matrix.length];

        for(int i =0; i < matrix[0].length ; i++){
           

           dp[0][i] =  matrix[0][i];
        }


        for(int row = 1; row < matrix.length ; row++){

            for(int col = 0; col < matrix.length ; col++){
                int left = (col - 1 < 0 )?  Integer.MAX_VALUE :  dp[row-1][col-1];
                int right = (col + 1 >= matrix[0].length)?  Integer.MAX_VALUE :  dp[row-1][col+1];
                int up =  dp[row-1][col];

               int ans1 = Math.min(left , right);

               ans1 = Math.min(up , ans1);

               dp[row][col] = ans1+matrix[row][col];


            }
        }


        for(int col =0; col < matrix[0].length ; col ++){
            ans = Math.min(ans , dp[matrix.length-1][col]);
        }


        
        return ans;
    }


   
}
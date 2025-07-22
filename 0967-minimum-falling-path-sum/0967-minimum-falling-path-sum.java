class Solution {
    public int minFallingPathSum(int[][] matrix) {


        int ans = Integer.MAX_VALUE ;
        int[] dp = new int[matrix.length];

        for(int i =0; i < matrix[0].length ; i++){
           

           dp[i] =  matrix[0][i];
        }


        for(int row = 1; row < matrix.length ; row++){

            int[] temp = new int[matrix.length];

            for(int col = 0; col < matrix.length ; col++){
                int left = (col - 1 < 0 )?  Integer.MAX_VALUE :  dp[col-1];
                int right = (col + 1 >= matrix[0].length)?  Integer.MAX_VALUE :  dp[col+1];
                int up =  dp[col];

               int ans1 = Math.min(left , right);

               ans1 = Math.min(up , ans1);

               temp[col] = ans1+matrix[row][col];


            }
            dp = temp;
        }


        for(int col =0; col < matrix[0].length ; col ++){
            ans = Math.min(ans , dp[col]);
        }


        
        return ans;
    }


   
}
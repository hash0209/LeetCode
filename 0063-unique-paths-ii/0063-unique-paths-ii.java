class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 || 
        obstacleGrid[0][0] == 1){
            return  0 ;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = 1;

        for(int r = 0; r < obstacleGrid.length ; r++ ){


            for(int c = 0; c < obstacleGrid[0].length ; c++){

                if( r== 0 && c== 0){
                    continue ;
                }


                if(obstacleGrid[r][c] == 1){
                    dp[r][c] = 0;
                }
                else{


                int up = 0;

                if(r-1 >=0){
                 up = dp[r-1][c];
                }

                int left = 0;

                if(c-1 >= 0){
                 left = dp[r][c-1];
                }

                dp[r][c] = up + left ;
            }
            }

        }


        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];





      
    }


}
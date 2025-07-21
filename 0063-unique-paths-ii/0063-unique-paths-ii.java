class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

       

        int[]dp = new int[obstacleGrid[0].length];

        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1 ;

        for(int r = 0; r < obstacleGrid.length ; r++ ){

            int[] temp = new int[obstacleGrid[0].length];
            temp[0] = dp[0];


            for(int c = 0; c < obstacleGrid[0].length ; c++){

                if( r== 0 && c== 0){
                    continue ;
                }


                if(obstacleGrid[r][c] == 1){
                    temp[c] = 0;
                }
                else{


                int up = 0;

                if(r-1 >=0){
                 up = dp[c];
                }

                int left = 0;

                if(c-1 >= 0){
                 left =temp[c-1];
                }

               temp[c] = up + left ;
            }
            }

           dp = temp ;

        }


        return dp[obstacleGrid[0].length-1];





      
    }


}
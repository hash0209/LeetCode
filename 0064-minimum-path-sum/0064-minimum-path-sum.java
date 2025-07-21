class Solution {
    public int minPathSum(int[][] grid) {

        int[] dp = new int[grid[0].length];


        dp[0] = grid[0][0];

        for(int r = 0; r < grid.length ; r++){

            int[] temp = new int[grid[0].length];
          


            for(int c = 0; c < grid[0].length ; c ++){

                if( r == 0 && c== 0){
                     temp[0] =  dp[0];
                }
                else{


                int up = Integer.MAX_VALUE ;

                if(r-1 >= 0){
                    up = dp[c] ;
                }

                int left = Integer.MAX_VALUE;


                if(c-1 >= 0){
                    left = temp[c-1] ;
                }



                temp[c] = Math.min(up,left) +  grid[r][c];
                }


                


            }

          dp = temp ;
        }

        return dp[grid[0].length-1];
        
    }

    
}
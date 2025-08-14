class Solution {
    public int cherryPickup(int[][] grid) {
          
           Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];

           
           return find(0 , 0 , grid[0].length-1 , grid,dp);
    }

    public int find(int i , int j1 , int j2 , int[][] grid , Integer[][][] dp  ){

        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >=grid[0].length){
            return Integer.MIN_VALUE;
        }

        if( i == grid.length-1){
            if(j1 ==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2]!= null){
            return dp[i][j1][j2];
        }

        int maxPoints = Integer.MIN_VALUE;

        for(int k1 = -1 ; k1 <= 1 ; k1++){

            for(int k2 =-1 ; k2 <= 1 ; k2++){
                  
                  int ans = find(i+1 , j1+k1 , j2+k2 , grid , dp );
                  if(ans!=Integer.MIN_VALUE){
                    if(j1 == j2){
                        ans= ans+ grid[i][j1];
                    }
                    else{
                        ans = ans + grid[i][j1] + grid[i][j2];
                    }


                  }

                  maxPoints =Math.max(maxPoints,ans);

            }
        }

        return dp[i][j1][j2] = maxPoints;

        
    }
}
class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length ; 
        int n = grid[0].length ;

        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for(int i=0; i < m ; i++){

            int[] temp = new int[n];



            for(int j =0; j < n ; j++){

                if(i == 0 && j ==0){
                    temp[0] = dp[0];
                    continue;
                }

                  int up = (i-1)>=0 ?dp[j] : Integer.MAX_VALUE;
                
                  int left = (j-1 >= 0) ? temp[j-1] : Integer.MAX_VALUE;

                  

                  temp[j] = Math.min(up,left) + grid[i][j]; 
            }
            dp = temp;
        }

        return dp[n-1];


        
        
    }
}
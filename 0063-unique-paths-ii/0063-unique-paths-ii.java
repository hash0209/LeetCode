class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return find(obstacleGrid , obstacleGrid.length -1 , obstacleGrid[0].length -1 , dp );
    }

    public int find(int[][] nums , int  r, int c , int[][] dp){

        if( r < 0 || c < 0 || nums[r][c] == 1){
            return 0;
        }

        if( r== 0 && c == 0){
            return 1;
        }

        if(dp[r][c]!=-1){
            return dp[r][c];
        }




        
        int up = find(nums , r-1 , c , dp);

        int left = find(nums , r , c-1 , dp);

        return  dp[r][c] = up + left ;
    }
}
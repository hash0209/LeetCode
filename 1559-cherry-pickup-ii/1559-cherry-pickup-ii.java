class Solution {
    public int cherryPickup(int[][] grid) {

        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] row : dp){
            for(int[] col : row){
            Arrays.fill(col , -1);
            }
        }
        return find(0,0,grid[0].length-1 , grid , dp);
    }

    public int find(int m1 , int n1 , int n2 , int[][] grid , int[][][] dp){

        
        if(m1 >= grid.length){
            return 0;
        }

        if(n1 < 0 || n1 >= grid[0].length || n2 < 0 || n2 >= grid[0].length  ){
            return  Integer.MIN_VALUE;
        }

        if(dp[m1][n1][n2] !=-1){
            return dp[m1][n1][n2];
        }

        int ans = Integer.MIN_VALUE;


        for(int i =n1-1 ; i <= n1+1 ; i++ ){

            int ans1 = Integer.MIN_VALUE;
              
                 
            for(int j = n2-1 ; j <= n2+1 ; j++){

                if(i != j){
                    ans1 = Math.max(find(m1+1 , i , j , grid , dp),ans1);
                }

            }

            ans = Math.max(ans , ans1 + grid[m1][n1] +grid[m1][n2]);
        }
        return dp[m1][n1][n2] = ans;
    }
}
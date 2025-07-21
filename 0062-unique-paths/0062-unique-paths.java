class Solution {
    public int uniquePaths(int m, int n) {


       // int[][] dp = new int[m][n];

       // dp[0][0]= 1; 


        int[] dp = new int[n];
        dp[0]= 1;
    

        

        int ans = 0;

        for (int r  = 0; r < m ; r ++){

            int[] temp = new int[n];
            
            for(int c = 0 ; c < n ; c ++){

                if( r== 0 && c == 0){
                    temp[0] = 1;
                    
                }
                else{

                int up = 0;

                if(r -1 >= 0){
                   up =  dp[c];
                }
                  

                  int left = 0;
                  if(c-1>=0){
                     left =temp[c-1];
                  }

                 temp[c] = up+left;

            }
            }

            dp = temp;
            
}

       return dp[n-1];

    }





}
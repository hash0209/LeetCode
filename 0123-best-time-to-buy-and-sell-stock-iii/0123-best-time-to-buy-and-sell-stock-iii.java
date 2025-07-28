class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][3];

        dp[0][1] = prices[prices.length-1];
        dp[0][2] = prices[prices.length-1];


        for(int idx = prices.length-2 ; idx >= 0 ; idx --){
            int [][] temp = new int[2][3];

            for(int buy =0; buy <= 1; buy++){

                for(int t = 1; t <= 2 ; t ++){
                    if(buy ==1 ){
                        int buys = dp[0][t] -  prices[idx];

                        int notbuys = dp[buy][t] ;

                       temp[buy][t] =Math.max(buys,notbuys);
                       

                       }
                       else{
                        int sell = dp[1][t-1] + prices[idx];

                        int notsell = dp[buy][t];

                        temp[buy][t] = Math.max(sell,notsell);
                       }
                    }
                }
                dp =temp;
            }

            return dp[1][2];
        }
        
    


    public int find(int idx , int buy , int t , int[] prices , Integer[][][] dp){

        if( t== 0){
            return 0;
        }

        if(idx == prices.length-1){
            if(buy ==0){
                return prices[prices.length-1];
            }
            return 0;
        }

        if(dp[idx][buy][t] != null){
            return dp[idx][buy][t];
        }




        if(buy == 1){
            int buys = find(idx+1 , 0 , t , prices,dp) - prices[idx];

            int notbuys = find(idx+1 , buy , t , prices,dp) ;
            return dp[idx][buy][t] =Math.max(buys,notbuys);
        }
        else{
            int sell = find(idx+1 , 1 , t-1 , prices,dp) + prices[idx];

            int notsell = find(idx+1 , buy , t , prices,dp);
            return dp[idx][buy][t] = Math.max(sell,notsell);
        }
    }
}
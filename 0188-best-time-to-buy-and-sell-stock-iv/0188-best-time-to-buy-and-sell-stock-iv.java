class Solution {
    public int maxProfit(int k, int[] prices) {

        int[][][] dp = new int[prices.length][2][k+1];

        for(int t = k; t > 0 ; t--){
            dp[prices.length-1][0][t] = prices[prices.length-1];
        }


        for(int idx = prices.length-2 ; idx >= 0 ; idx--){

            for(int buy =0; buy <= 1; buy ++){


                for(int t =1 ; t <= k ; t++){

                    if(buy ==1){

                        int buys = dp[idx+1][0][t] - prices[idx];

                        int notbuys = dp[idx+1][buy][t];

                        dp[idx][buy][t] =Math.max(buys,notbuys);

                    
                    }
                    else{
                        int sell = dp[idx+1][1][t-1] + prices[idx];
                        int notsell = dp[idx+1][buy][t];

                        dp[idx][buy][t] = Math.max(sell,notsell);
                    }
                }
            }
        }

        return dp[0][1][k];
        
    }
}
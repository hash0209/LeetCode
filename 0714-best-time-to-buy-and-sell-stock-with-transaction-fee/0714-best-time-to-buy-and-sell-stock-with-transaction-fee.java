class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];

        dp[prices.length-1][0] = (prices[prices.length-1] > fee )? prices[prices.length-1]- fee : 0;

        for (int idx = prices.length-2 ; idx >= 0; idx--){

            for(int buy =0; buy <= 1; buy++){

                if(buy==1){

                    int buys = dp[idx+1][0] - prices[idx];

                    int notbuys = dp[idx+1][buy];

                    dp[idx][buy] =Math.max(buys,notbuys);
                }
                else{
                    int sell = dp[idx+1][1] + prices[idx] - fee;

                    int notsell = dp[idx+1][buy];

                    dp[idx][buy] =Math.max(sell,notsell);
                }
            }
        }

        return dp[0][1];


        
    }
}
class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length+1][2];

        for(int idx = prices.length-1; idx >=0  ; idx--){
               dp[idx][1] = Math.max(dp[idx+1][0] - prices[idx] ,dp[idx+1][1]);
               dp[idx][0] = Math.max(dp[idx+1][1] + prices[idx] ,dp[idx+1][0]);
        }


        return dp[0][1];
    }

    public int find(int[] prices , int buy , int idx, Integer[][] dp  ){

        if(idx ==prices.length){
            return 0;
        }
        if(dp[idx][buy]!=null){
           return dp[idx][buy];
        }

            if(buy ==1){
                int buys = find(prices , 0 , idx+1 ,dp )  -prices[idx];

                int notbuy = find(prices , 1 , idx+1 ,dp );

                return dp[idx][buy] = Math.max(buys,notbuy);
            }
            else{
                int sell = find(prices,1,idx+1 ,dp) +prices[idx];

                int notsell = find(prices , 0 , idx+1 ,dp );

                return dp[idx][buy] =Math.max(sell,notsell);
            }




    }
}
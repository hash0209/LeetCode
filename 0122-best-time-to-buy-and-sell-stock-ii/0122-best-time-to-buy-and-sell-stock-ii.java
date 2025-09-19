class Solution {
    public int maxProfit(int[] prices) {

        Integer[][] dp = new Integer[prices.length][2];


        return find(prices,1,0,dp);
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
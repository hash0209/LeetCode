class Solution {
    public int maxProfit(int[] prices) {

        Integer[][] dp = new Integer[prices.length][2];

        return find(0,1, prices , dp);
        
    }
    public int find(int idx , int buy , int[] prices , Integer[][] dp ){

        if(idx == prices.length-1){
            if(buy == 0){
                return  prices[idx];
            }
            return 0;
        }

        if(dp[idx][buy]!= null){
            return dp[idx][buy];
        }
        

        if( buy == 1){

            int buys = find(idx+1 , 0 , prices ,dp) -prices[idx];

            int notbuys = find(idx+1 , buy , prices ,dp);

            return dp[idx][buy]=  Math.max(buys,notbuys);
        }
        else{
            int sell = find(idx+1,1 , prices,dp) + prices[idx];

            int notsell = find(idx+1 ,buy , prices , dp);

            return dp[idx][buy] = Math.max(sell,notsell);
        }
    }
}
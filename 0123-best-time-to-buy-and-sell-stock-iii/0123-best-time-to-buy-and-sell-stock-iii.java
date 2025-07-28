class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][3];
        return find(0,1 , 2 , prices,dp);
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
class Solution {
    public int maxProfit(int k, int[] prices) {

            Integer[][][] dp = new Integer[prices.length][k+1][2];
              
             return find(0,prices,k,1,dp);
        
    }

    public int find(int idx , int[] prices , int k , int buy , Integer[][][] dp){

        if(k == 0){
            return 0;
        }
        if(idx == prices.length){
            return  0;
        }

        if(dp[idx][k][buy]!=null){
            return dp[idx][k][buy];
        }

        if(buy == 1){
            int buys = find(idx+1,prices , k , 0,dp) -prices[idx];

            int notbuys = find(idx+1 , prices , k , 1,dp );

            return dp[idx][k][buy] = Math.max(buys,notbuys);    
        }
        else{

            int sell = find(idx+1 , prices , k-1 , 1,dp)+prices[idx];

            int notsell = find(idx+1,prices, k , 0,dp) ;

            return dp[idx][k][buy] =Math.max(sell,notsell);

        }
    }
}
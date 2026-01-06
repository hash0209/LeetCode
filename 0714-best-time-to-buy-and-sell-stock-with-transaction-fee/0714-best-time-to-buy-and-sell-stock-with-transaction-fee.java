class Solution {
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }


        return calc(0 , prices , 1 , fee , dp);
        
    }

    public int calc(int index , int[] prices , int buy ,  int fee , int[][] dp){

        if(index == prices.length-1){
            if(buy == 1){
                return 0;
            }
            else {
                return prices[index] - fee;
            }
        }

        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }

        if(buy ==1){
            int buys = calc(index+1 , prices , 0 , fee , dp) - prices[index];

            int notbuy = calc(index+1 , prices , 1 , fee ,dp);

            return  dp[index][buy]= Math.max(buys,notbuy);
        }
        else{
            int sell = calc(index+1 , prices , 1 , fee ,dp) + prices[index] -fee;

            int notsell = calc(index+1 , prices , 0 , fee ,dp);

            return  dp[index][buy]= Math.max(sell,notsell); 
        }

    }
}
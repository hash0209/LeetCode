class Solution {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][2][2];

        dp[prices.length-1][0][0] = prices[prices.length-1];

        for(int idx = prices.length-2 ; idx >= 0; idx --){

            for(int buy=0; buy <= 1 ; buy++){

                for(int cooldown =0 ; cooldown <=1 ; cooldown++){

                      if(cooldown ==1){
                         dp[idx][buy][cooldown] = dp[idx+1][buy][0];
                      }
                      else{ //cooldown = 0
                        if(buy ==1){
                            int buys = dp[idx+1][0][cooldown] - prices[idx];

                            int notbuys = dp[idx+1][buy][cooldown] ;

                            dp[idx][buy][cooldown]=  Math.max(buys,notbuys);
                        }
                        else{
                            int sell = dp[idx+1][1][1] + prices[idx];

                            int notsell = dp[idx+1][buy][cooldown];

                            dp[idx][buy][cooldown] = Math.max(sell,notsell);
                       }
                      }
                        

                    }
                }
            }

            return dp[0][1][0];




        }



        
    }

    

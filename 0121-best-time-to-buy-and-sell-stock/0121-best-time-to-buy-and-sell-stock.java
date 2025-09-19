class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length== 0 || prices.length==1){
            return 0;
        }

        int buy = prices[0];
        int profit =0;

        for(int i = 1; i < prices.length ; i++){
            if(prices[i] > buy){
            
                profit = Math.max(profit , prices[i]- buy);
            }
            
            buy = Math.min(buy,prices[i]);
        }

        return profit;

        
    }
}
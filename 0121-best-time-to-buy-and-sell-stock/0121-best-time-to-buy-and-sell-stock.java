class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length== 0 || prices.length==1){
            return 0;
        }

        int buy = prices[0];
        int profit =0;

        for(int sell = 1; sell < prices.length ; sell++){
            
                profit = Math.max(profit , prices[sell]- buy);
            
            buy = Math.min(buy,prices[sell]);
        }

        return profit;

        
    }
}
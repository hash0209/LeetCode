class Solution {
    public int maxProfit(int[] prices) {

        int ans = 0;
        int minElement = prices[0];


        for(int i = 1; i < prices.length ; i++){
            ans = Math.max(prices[i] -minElement , ans);
            minElement = Math.min(minElement , prices[i]);
        }

        return ans;

       
        
    }
}
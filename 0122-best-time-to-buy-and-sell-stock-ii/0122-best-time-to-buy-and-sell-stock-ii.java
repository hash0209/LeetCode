class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    public int find(int[] prices, int buy, int idx, Integer[][] dp) {

        if (idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy] != null) {
            return dp[idx][buy];
        }

        if (buy == 1) {
            int buys = find(prices, 0, idx + 1, dp) - prices[idx];

            int notbuy = find(prices, 1, idx + 1, dp);

            return dp[idx][buy] = Math.max(buys, notbuy);
        } else {
            int sell = find(prices, 1, idx + 1, dp) + prices[idx];

            int notsell = find(prices, 0, idx + 1, dp);

            return dp[idx][buy] = Math.max(sell, notsell);
        }

    }
}
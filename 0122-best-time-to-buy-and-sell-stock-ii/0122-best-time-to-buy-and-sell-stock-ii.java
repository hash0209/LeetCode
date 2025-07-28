class Solution {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];

        dp[0][1] = -prices[0];

        for (int idx =1; idx < prices.length ; idx++) {

            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {

                    int buys = dp[idx - 1][0] -  prices[idx];

                    int notbuys = dp[idx - 1][buy];

                     dp[idx][buy] = Math.max(buys, notbuys);
                } else {
                    int sell = dp[idx - 1][1] + prices[idx];

                    int notsell = dp[idx -  1][buy];

                     dp[idx][buy] = Math.max(sell, notsell);
                }
            }
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }

    public int find(int idx, int buy, int[] prices, Integer[][] dp) {

        if (idx == prices.length - 1) {
            if (buy == 0) {
                return prices[idx];
            }
            return 0;
        }

        if (dp[idx][buy] != null) {
            return dp[idx][buy];
        }

        if (buy == 1) {

            int buys = find(idx + 1, 0, prices, dp) - prices[idx];

            int notbuys = find(idx + 1, buy, prices, dp);

            return dp[idx][buy] = Math.max(buys, notbuys);
        } else {
            int sell = find(idx + 1, 1, prices, dp) + prices[idx];

            int notsell = find(idx + 1, buy, prices, dp);

            return dp[idx][buy] = Math.max(sell, notsell);
        }
    }
}
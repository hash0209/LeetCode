class Solution {
    public int maxProfit(int k, int[] prices) {

        int[][] dp = new int[k + 1][2];

        for (int idx = prices.length - 1; idx >= 0; idx--) {

            int[][] temp = new int[k+1][2];
            for (int buy = 0; buy <= 1; buy++) {
                for (int t = 1; t <= k; t++) {
                    if (buy == 1) {
                        int buys = dp[t][0] - prices[idx];

                        int notbuys = dp[t][1];

                        temp[t][buy] = Math.max(buys, notbuys);
                    } else {
                        int sell = dp[t-1][1] + prices[idx];

                        int notsell = dp[t][0];

                         temp[t][buy] = Math.max(sell, notsell);
                    }
                }
            }

           dp=temp;
        }

        return dp[k][1];

    }

    public int find(int idx, int[] prices, int k, int buy, Integer[][][] dp) {

        if (k == 0) {
            return 0;
        }
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][k][buy] != null) {
            return dp[idx][k][buy];
        }

        if (buy == 1) {
            int buys = find(idx + 1, prices, k, 0, dp) - prices[idx];

            int notbuys = find(idx + 1, prices, k, 1, dp);

            return dp[idx][k][buy] = Math.max(buys, notbuys);
        } else {

            int sell = find(idx + 1, prices, k - 1, 1, dp) + prices[idx];

            int notsell = find(idx + 1, prices, k, 0, dp);

            return dp[idx][k][buy] = Math.max(sell, notsell);

        }
    }
}
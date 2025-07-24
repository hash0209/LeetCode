class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

      
            dp[0] = 0;
        

        for (int amt = 1; amt <= amount; amt++) {
            if (amt >= coins[0] && (amt % coins[0]) == 0) {
                dp[amt] = (amt / coins[0]);
            }
            else{
            dp[amt] = Integer.MAX_VALUE;
            }
        }

        for (int idx = 1; idx < coins.length; idx++) {
            int[] temp = new int[amount+1];
            temp[0] = 0;

            for (int amt = 1; amt <= amount; amt++) {

                int pick = Integer.MAX_VALUE;

                if (amt >= coins[idx]) {
                    pick = temp[amt - coins[idx]];
                    pick = (pick == Integer.MAX_VALUE) ? pick : pick + 1;
                }

                int notPick = dp[amt];

                 temp[amt] = Math.min(pick, notPick);

            }
            dp = temp;
        }

        int ans = dp[amount];
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int find(int idx, int amt, int[] coins, int[][] dp) {
        if (amt == 0) {
            return 0;
        }
        if (idx == 0) {

            if (amt >= coins[0] && (amt % coins[0]) == 0) {
                return (amt / coins[0]);
            }
            return Integer.MAX_VALUE;

        }
        if (dp[idx][amt] != -1) {
            return dp[idx][amt];
        }

        int pick = Integer.MAX_VALUE;

        if (amt >= coins[idx]) {
            pick = find(idx, amt - coins[idx], coins, dp);
            pick = (pick == Integer.MAX_VALUE) ? pick : pick + 1;
        }

        int notPick = find(idx - 1, amt, coins, dp);

        return dp[idx][amt] = Math.min(pick, notPick);

    }
}
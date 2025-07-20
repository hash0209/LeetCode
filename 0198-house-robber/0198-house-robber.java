class Solution {
    public int rob(int[] nums) {

        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {

            for (int p = 0; p <= 1; p++) {
                int pick = Integer.MIN_VALUE;

                if (p == 1) {
                    pick = dp[idx - 1][0] + nums[idx];
                }

                int notPick = dp[idx - 1][1];

                 dp[idx][p] = Math.max(pick, notPick);
            }

        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);

    }

}
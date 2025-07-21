class Solution {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        //Arrays.fill(dp, -1);

        dp[0] = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {

            int pick = nums[idx];

            if (idx - 2 >= 0) {

                pick = pick + dp[idx - 2];
            }

            int notPick = 0;

            if (idx - 1 >= 0) {

                notPick = dp[idx - 1];
            }

            dp[idx] = Math.max(pick, notPick);
        }

        return dp[nums.length - 1];

    }

}
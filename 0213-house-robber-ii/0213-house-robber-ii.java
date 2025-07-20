class Solution {
    public int rob(int[] nums) {

       

        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = 0;

        for (int idx = 1; idx < nums.length - 1; idx++) {

            int[] temp = new int[2];

            for (int p = 0; p <= 1; p++) {

                int pick = Integer.MIN_VALUE;

                if (p == 1) {
                    pick = dp[0] + nums[idx];

                }

                int notPick = dp[1];

                temp[p] = Math.max(pick, notPick);
            }

            dp = temp;
        }

        int ans11 = dp[0] + nums[nums.length - 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int idx = 1; idx < nums.length - 1; idx++) {
            int[] temp = new int[2];
            for (int p = 0; p <= 1; p++) {
                int pick = Integer.MIN_VALUE;

                if (p == 1) {
                    pick = dp[0] + nums[idx];

                }

                //  int notPick = Integer.MIN_VALUE;

                int notPick = dp[1];

                temp[p] = Math.max(pick, notPick);
            }
            dp = temp;
        }

        int ans22 = dp[1];

        return Math.max(ans11, ans22);

    }

}
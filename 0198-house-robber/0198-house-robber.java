class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] =nums[0];

        for(int idx =1 ; idx < nums.length ; idx++){

               int pick = (idx-2)>=0 ? dp[idx-2] + nums[idx] : nums[idx] ;

               int notpick = dp[idx-1];

               dp[idx]=Math.max(pick,notpick);

        }

        return dp[nums.length-1];
    }
}
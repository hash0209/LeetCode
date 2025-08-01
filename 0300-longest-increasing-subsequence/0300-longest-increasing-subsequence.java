class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int idx = nums.length-1 ; idx >= 0; idx--){
            for(int prev = idx-1 ; prev >= -1 ; prev--){
                int pick = 0;

                if(prev == -1 || nums[idx] > nums[prev]){
                    pick = dp[idx+1][idx+1]+1;
                }
                int notpick = dp[idx+1][prev+1];

                dp[idx][prev+1] = Math.max(pick,notpick);

            }
        }
        return dp[0][0];
    }

 
}
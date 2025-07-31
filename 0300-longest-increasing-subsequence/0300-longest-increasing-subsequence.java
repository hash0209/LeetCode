class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];

        for(int last =0; last <= nums.length ; last++){
            if(last == nums.length || nums[0] < nums[last]){
                dp[0][last] =1 ;
            }
        }

        for(int idx =1; idx < nums.length ; idx++){
            

            for(int last =idx+1; last <= nums.length ; last++){

                int pick = 0;
                if(last == nums.length || nums[idx] < nums[last]){
                    pick = dp[idx-1][idx]+1;
                }

                int notpick = dp[idx-1][last];

              dp[idx][last] = Math.max(pick,notpick);
            }
           
        }


        return dp[nums.length-1][nums.length];
    }


}
class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return find(0,-1,nums , dp);
    }

    public int find(int idx , int prev , int[] nums , Integer[][] dp){
        if(idx == nums.length){
            return 0;
        }

        if(dp[idx][prev+1]!=null){
            return dp[idx][prev+1];
        }

        int pick = 0;


        if(prev == -1 || nums[idx] > nums[prev]){
            pick = find(idx+1,idx , nums,dp)+1;
        }
        int notpick = find(idx+1 , prev , nums,dp);
        return dp[idx][prev+1] = Math.max(pick , notpick);
    }
}
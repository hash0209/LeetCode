class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return find(nums.length-1 , nums.length, nums,dp);
    }

    public int find(int idx , int last  , int[] nums , Integer[][] dp){
        if(idx == 0){
            if(last == nums.length || nums[idx] < nums[last]){
                return 1;
            }
            return 0;
        }

        if( dp[idx][last]!=null){
            return dp[idx][last];
        }

        int pick = 0;

    

        if(last == nums.length || nums[idx] <  nums[last]){
            pick = find(idx-1 , idx , nums ,dp)+1;
        }

        int notpick = find(idx-1 , last , nums ,dp);

        return dp[idx][last] = Math.max(pick,notpick);
    }
}
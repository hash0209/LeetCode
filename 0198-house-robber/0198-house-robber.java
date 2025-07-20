class Solution {
    public int rob(int[] nums) {

        int[][] dp = new int[nums.length][2];

        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        return find(nums , nums.length-1 , 1 , dp);
    }


    public int find (int [] nums , int idx , int p , int[][] dp){


        if(idx ==0){
            if (p == 1){
                return nums[idx];
            }
            else{
                return 0;
            }
        }

        if(dp[idx][p] !=-1){
            return dp[idx][p];
        }

        int pick =Integer.MIN_VALUE;


        if(p == 1){
              pick = find(nums , idx-1 , 0 , dp) + nums[idx];
        }

        int notPick = find(nums , idx-1 , 1 , dp);


        return dp[idx][p] = Math.max(pick , notPick);
    }
}
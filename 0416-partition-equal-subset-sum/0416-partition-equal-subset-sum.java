class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i < nums.length ; i++){
            sum += nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        int target = sum/2;

        boolean[] dp = new boolean[target+1];
        dp[0]= true;
        for(int t =1; t <= target ; t++){
            if(nums[0]==t){
                dp[t] =true;
            }
        }
        for(int i =1 ; i< nums.length ; i++){
             boolean[] temp = new boolean[target+1];
             temp[0]=true;
             for(int t =1; t<= target ;t++){
                 boolean pick = false;
                 if(t >= nums[i]){
                    pick = dp[t-nums[i]];
                 }
                 boolean notpick = dp[t];

                 temp[t] = pick || notpick;
             }
             dp = temp;
        }

        return dp[target];

        
        
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        
     int sum = 0;

     for(int i = 0; i < nums.length ; i++){
        sum+=nums[i];
     }

     if(sum %2 == 1){
        return false;
     }

     sum = sum/2;

     int[][] dp = new int[nums.length][sum+1];

    for(int idx = 0; idx < nums.length ; idx++){
        dp[idx][0] =1;
    }

    for(int t = 1 ; t <= sum ; t ++){
        if(nums[0]==t){
            dp[0][t] = 1;
        }
    }


    for(int idx = 1; idx < nums.length ; idx++){
        

        for(int target =1 ; target <= sum ; target++){


            int take = 0;

            if(target >= nums[idx]){
                take = dp[idx-1][target-nums[idx]];
            }

            int notTake = dp[idx-1][target];

            if(take == 1 || notTake ==1){
                dp[idx][target] =1;
              }
              else{
                 dp[idx][target] =0;
              }
        }
    }




     return dp[nums.length-1][sum] ==1 ? true : false;
    }

    public boolean find(int[] nums , int idx , int target , int[][] dp){
              if(target == 0){
                return true;
              }
              if(idx == 0){
                if(nums[0]== target){
                    return true;
                }
                return false;
              }

              if(dp[idx][target]!=-1){
                return dp[idx][target] ==1 ? true : false;
              }



              boolean take = false;

              if(target >= nums[idx]){
                take = find(nums , idx-1 , target-nums[idx] , dp);
              }

              boolean notTake = find(nums , idx-1 , target , dp);

              if(take || notTake){
                dp[idx][target] =1;
              }
              else{
                 dp[idx][target] =0;
              }

              return   take || notTake;
    }
}
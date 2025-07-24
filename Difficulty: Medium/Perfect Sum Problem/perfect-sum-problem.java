class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        
        int[][] dp = new int[nums.length][target+1] ;
        
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        
        
      //  for(int t= 0 ; t <= target ; t++){
       //     if(t == nums[0]){
       //         dp[0][t] =1;
       //     }
      //  }
    
        
        // code here
        return (target == 0) ? find(nums , nums.length-1,target , dp) + 1 : find(nums , nums.length-1,target , dp);
        
        
    }
    
    public int find(int[] nums , int idx , int target , int[][] dp){
        if(idx == 0){
            if(target == nums[0]){
                return 1;
            }
            return 0;
        }
        
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
       
        
        int pick = 0;
          if(target >= nums[idx]){
           
              pick  = find(nums, idx-1 , target-nums[idx] , dp);
          }
          
          int notpick = find(nums , idx-1 , target , dp);
          
          
         return dp[idx][target] = (target ==  nums[idx]) ? pick +notpick+1 : pick+notpick;
    
        
        
        
        
        
    }
}
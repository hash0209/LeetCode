class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int[][] dp = new int[arr.length][sum+1];
        
        for(int t =0 ; t <= sum ; t++){
            if(arr[0] == t){
        
        dp[0][arr[0]] =1;
            }
        }
            
        
        
        for(int idx = 0; idx < arr.length ; idx++){
            dp[idx][0]=1;
        }
        
        for(int idx = 1 ; idx < arr.length ; idx++){
            
            for(int t =1 ; t <= sum ; t++){
                
                int pick = (t-arr[idx]) >= 0 ? dp[idx-1][t-arr[idx]] : 0;
                
                int notpick = dp[idx-1][t] ;
                
                if(pick ==1 || notpick ==1){
                    dp[idx][t] =1;
                }
            }
        }
        
        
        return dp[arr.length-1][sum] == 1;
        
    }
}
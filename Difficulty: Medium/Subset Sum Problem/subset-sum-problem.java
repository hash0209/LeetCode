class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean[][] dp = new boolean[arr.length][sum+1];
        for(int i = 0; i < arr.length ; i++){
            dp[i][0] = true;
        }
        
        for(int t =1 ; t<= sum ; t++){
            if(arr[0] == t){
        
        dp[0][t] = true;
            }
        }
        
        
        for(int i =1; i < arr.length ; i++){
            for(int t =1 ; t<= sum ; t++){
                
                boolean pick = false;
                if(t >= arr[i]){
                    pick = dp[i-1][t-arr[i]];
                }
                
                boolean notpick = dp[i-1][t];
                
                dp[i][t] = pick || notpick;
                
            }
        }
        
        return dp[arr.length-1][sum];
    }
}
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int[] dp = new int[sum+1];
        
        for(int t =0 ; t <= sum ; t++){
            if(arr[0] == t){
        
        dp[arr[0]] =1;
            }
        }
            
        
        
       dp[0]=1;
        
        for(int idx = 1 ; idx < arr.length ; idx++){
            
            int[] temp = new int[sum+1];
            temp[0]=1;
            
            for(int t =1 ; t <= sum ; t++){
                
                int pick = (t-arr[idx]) >= 0 ? dp[t-arr[idx]] : 0;
                
                int notpick = dp[t] ;
                
                if(pick ==1 || notpick ==1){
                    temp[t] =1;
                }
            }
            dp =temp;
        }
        
        
        return dp[sum] == 1;
        
    }
}
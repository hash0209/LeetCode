
class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        
        int sum= 0;
        for(int i =0; i < arr.length ; i++){
            sum+=arr[i];
        }
        
        int target = sum + d;
        
        if(target % 2 == 1){
            return 0;
        }
        
        target= target/2;
        
        int[] dp = new int[target+1];
        
        for(int t = 0; t <= target ; t++){
            if(t == arr[0]){
                dp[t] =1;
            }
        }
        
        for(int idx = 1; idx < arr.length ; idx++){
            int[] temp = new int[target+1];
            for(int  t=0 ; t <= target ; t++){
                int pick = (t >= arr[idx]) ? dp[t-arr[idx]] : 0;
                int notPick = dp[t];
                
                temp[t] = (t == arr[idx]) ?  pick+notPick+1 : pick+notPick ;
            }
            dp = temp;
        }
        
        
        
        
        return dp[target];
        
        
        
        
        
    }
    
    
    public int find(int[] arr , int target , int idx , int[][] dp){
        if(idx == 0){
            if(target == arr[0]){
                return 1;
            }
            return 0;
                
          
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        
        
        
        int pick = (target >= arr[idx]) ? find(arr , target-arr[idx]  , idx-1 , dp) : 0;
        
        int notPick = find(arr,target , idx-1,dp);
        
        
        return  dp[idx][target] =  (target == arr[idx]) ? pick+notPick+1 : pick+notPick ;
    }
}

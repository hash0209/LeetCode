// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        
        int sum = 0;
        
        for (int i =0; i < arr.length ; i++){
            sum+=arr[i];
        }
        
        int[][] dp = new int[arr.length][sum+1];
        
        for(int idx =0; idx < arr.length ; idx++){
            dp[idx][0] = 0;
        }
        
        for(int t =0; t <= sum ; t++){
            if(arr[0] == t){
                dp[0][t] =1;
            }
        }
        
        
        for(int idx = 1; idx < arr.length ; idx++){
            
            for(int t =1; t <= sum ; t++){
                
                int pick  = (t >= arr[idx] )?  dp[idx-1] [t-arr[idx]] : Integer.MAX_VALUE;
                int notPick  = dp[idx-1][t];
                
                
                if(pick ==1 || notPick == 1){
                    dp[idx][t] = 1;
                }
                else{
                    dp[idx][t]=0;
                }
            }
        }
        
        
        int diff = Integer.MAX_VALUE;
        
        
        for(int t =0; t <= sum ; t ++){
            if(dp[arr.length-1][t] == 1){
                int sum1 = t;
                int sum2 =sum -sum1;
                
                diff = Math.min(diff , Math.abs(sum1-sum2));
            }
        }
        
        return diff;
        
        
        
        
        
        
        
        
        
        
       
        
        
        
    }
}

// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        
        int[][] dp = new int[arr.length][arr[0].length];
        // code here
        dp[0][0] =arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2] =arr[0][2];
        
        for(int days =1 ; days< arr.length ; days++){
            
            for(int curr =0 ; curr < 3 ; curr++){
                
                int maxpoints =0;
                
                
                for(int prev =0; prev < 3 ; prev ++){
                    if(prev!= curr){
                        maxpoints = Math.max(maxpoints , dp[days-1][prev]);
                    }
                }
                dp[days][curr] = maxpoints + arr[days][curr];
            }
        }
        
       int max =0;
       
       for(int i =0 ; i < 3 ; i++){
           max = Math.max(max,dp[arr.length-1][i]);
       }
       return max;
    }
}
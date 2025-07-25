// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        
        
        int[][] dp = new int[wt.length][capacity+1];
        
        for(int idx =0; idx < wt.length ; idx++){
            
            dp[idx][0] = 0;
        }
        
        for(int cap =1 ; cap <= capacity ; cap++){
            if(cap >= wt[0]){
                dp[0][cap] =  (cap/wt[0]) * val[0];
            }
        }
        
        for(int idx =1 ; idx < wt.length ; idx++){
            
            for(int cap=1; cap <= capacity ; cap++){
                
                int pick = (cap >= wt[idx]) ?  dp[idx][cap-wt[idx]] + val[idx] : Integer.MIN_VALUE;
                
                int notpick = dp[idx-1][cap];
                
                
                dp[idx][cap] = Math.max(pick , notpick);
                
                
            }
        }
        
        
        
        
        // code here
        return dp[wt.length-1][capacity];
    }
    
    static int find(int[] val , int[] wt , int cap , int idx){
        
        if(cap == 0){
            return 0;
        }
        
        if(idx == 0){
            if(cap >= wt[0]){
                return (cap/wt[0]) * val[0];
            }
            return 0;
        }
        
        
        int pick = Integer.MIN_VALUE;
        
        if(cap >= wt[idx]){
            pick = find(val , wt , cap-wt[idx] , idx) + val[idx];
        }
        
        int notpick = find(val , wt , cap , idx-1);
        
        return Math.max(pick,notpick);
        
        
    }
}
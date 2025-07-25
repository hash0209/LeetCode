class Solution {
    public int cutRod(int[] price) {
        // code here
        
        int len = price.length;
        
        int[][] dp = new int[price.length][len+1];
        
        
        for(int idx =0; idx < price.length ; idx++){
            
            dp[idx][0] = 0;
            
        }
        
        for(int length = 1; length <= len ; length ++){
            dp[0][length] =(length * price[0]);
        }
        
        
        for(int idx =1 ; idx < price.length ; idx++){
            
            for(int length =1 ; length <= len ; length ++){
                
                int pick = (length >= idx+1) ? dp[idx][length-(idx+1)] + price[idx] : 0;
                
                int notpick = dp[idx-1][length];
                
                
                dp[idx][length] = Math.max(pick,notpick);
            }
        }
        
      return   dp[price.length-1][len];
        
    }
    
    public int find(int idx , int length , int[] price){
        
        if(length == 0){
            return 0;
        }
        
        if(idx == 0){
          
                return length*price[0];
            
          
        }
        
        
        int pick = 0;
        
        if(length >= idx+1){
            pick = find(idx , length-(idx+1) , price) + price[idx];
        }
        
        int notpick = find(idx-1 , length , price) ;
        
        return Math.max(pick,notpick);
    }
}
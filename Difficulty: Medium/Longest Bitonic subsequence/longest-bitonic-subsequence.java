
class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        
        for(int i =0;  i < nums.length ; i++ ){
            
            for(int j = 0; j < i ; j++){
                
                if(nums[i] > nums[j] && dp[i] < dp[j]+1){
                    dp[i] =dp[j]+1;
                }
            }
        }
        
        
        int[] prev = new int[n];
        Arrays.fill(prev ,1);
        
        int[] max = new int[n];
         Arrays.fill(max ,1);
        
        
        
        int maxi = 1;
        
        for(int i =nums.length-1;  i >=0 ; i-- ){
            
            for(int j = i+1; j < nums.length ; j++){
                
                if(nums[i] > nums[j] && prev[i] < prev[j]+1){
                    prev[i] =prev[j]+1;
                    maxi = Math.max(prev[i],maxi);
                   
                }
                 max[i] = maxi;
            }
        }
        
        int maxlength= 0;
        
        for(int i =0; i < nums.length ;i++){
            int left = dp[i];
            if(left!= 1){
            int right = max[i];
           if( right!=1 ){
               maxlength = Math.max(maxlength , left+right-1);
           }
            }
            
        }
        
        return maxlength;
        
        
        
        
        
    }
}

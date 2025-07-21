// User function Template for Java


class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        
        
        
        int[] dp = new int[3];
        
        dp[0] = arr[0][0];
        dp[1]= arr[0][1];
        dp[2] = arr[0][2];
        
        
        
        for(int days = 1; days < arr.length ; days++){
            
            int[] temp = new int[3];
            
           for(int i =0 ; i < 3 ; i++){
               
               
               int ans = Integer.MIN_VALUE;
               
               for(int choosen = 0; choosen < 3 ; choosen++){
                   
                   if(i!=choosen){
                   
                   ans = Math.max(ans , dp[choosen]);
                   }
                   
               }
               
              temp[i] = ans + arr[days][i]; 
               
               
               
               
           }
           
           dp =temp;
   
        
     
       
    }
    
     int ans = Integer.MIN_VALUE;
    
    
    
    for(int i = 0; i < 3 ; i++){
     
        
          ans = Math.max(dp[i],ans);
        
    }
    
    return ans;
    
    
  
}
}
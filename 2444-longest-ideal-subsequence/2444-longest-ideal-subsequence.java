class Solution {
    public int longestIdealString(String s, int k) {
         
         int[] dp = new int[26];

         int maxlen = Integer.MIN_VALUE;

         for(int i =0; i < s.length() ;i++){
            
            int max =0;

            int idx= s.charAt(i) -'a';

            for(int j = idx -k ; j <= idx +k ; j++){
                    if( j >= 0 && j <= 25){
                        max= Math.max(max , dp[j]);
                    }
            }

           // dp[idx] = Math.max(dp[idx] , max+1);
           dp[idx] = max+1;
            maxlen = Math.max(dp[idx], maxlen);




         }

         return maxlen;

    }
}
class Solution {
    public int longestIdealString(String s, int k) {
        
        int[] dp = new int[26];
        int ans =0;

        for(int i =0; i < s.length(); i++){
              int idx = s.charAt(i) - 'a';

              int start= Math.max(0,idx-k);
              int end = Math.min(25,idx+k);

              int maxlen = 0;

              for(int range = start ; range <= end ; range++){
                   maxlen = Math.max(maxlen,dp[range]);
              }

              dp[idx] = Math.max(dp[idx],1+maxlen);
              System.out.println(dp[idx]);
              ans = Math.max(ans,dp[idx]);
        }

        return ans;

    
    }
}
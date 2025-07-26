class Solution {
    public int longestPalindromeSubseq(String s) {

        StringBuilder s1 = new StringBuilder(s);
        String s2 = s1.reverse().toString();

        int[][] dp = new int[s.length()+1][s2.length()+1];

        for(int i =1 ; i <= s.length() ; i++){

            for(int j =1 ; j <= s2.length(); j++){
                 if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                 }
                 else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                 }

            }
        }

        return dp[s.length()][s2.length()];
        
    }
}
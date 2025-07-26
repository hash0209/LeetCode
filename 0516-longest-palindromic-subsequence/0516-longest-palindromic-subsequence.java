class Solution {
    public int longestPalindromeSubseq(String s) {

        StringBuilder s1 = new StringBuilder(s);
        String s2 = s1.reverse().toString();

        int[] dp = new int[s2.length()+1];

        for(int i =1 ; i <= s.length() ; i++){
            int[] temp = new int[s2.length()+1];

            for(int j =1 ; j <= s2.length(); j++){
                 if(s.charAt(i-1)==s2.charAt(j-1)){
                    temp[j] = 1+ dp[j-1];
                 }
                 else{
                    temp[j] = Math.max(temp[j-1],dp[j]);
                 }

            }
            dp = temp;
        }

        return dp[s2.length()];
        
    }
}
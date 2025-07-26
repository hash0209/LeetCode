class Solution {
    public int longestPalindromeSubseq(String s) {

       // StringBuilder s1 = new StringBuilder(s);
       // String s2 = s1.reverse().toString();

        int[] dp = new int[s.length()+1];

        for(int i =1 ; i <= s.length() ; i++){
            int[] temp = new int[s.length()+1];

            for(int j =1 ; j <= s.length(); j++){
                 if(s.charAt(i-1)==s.charAt(s.length()-j)){
                    temp[j] = 1+ dp[j-1];
                 }
                 else{
                    temp[j] = Math.max(temp[j-1],dp[j]);
                 }

            }
            dp = temp;
        }

        return dp[s.length()];
        
    }
}
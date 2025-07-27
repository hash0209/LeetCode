class Solution {
    public int numDistinct(String s, String t) {
        Integer[] dp = new Integer[t.length()+1];
        dp[0] = 1;

        for(int j =1; j <= t.length(); j++){
            dp[j] = 0;
        }

        for(int i = 1 ; i <= s.length() ; i++){
            Integer[] temp = new Integer[t.length()+1];
            temp[0] = 1;

            for(int j =1 ; j <= t.length() ; j++){

                if(s.charAt(i-1)==t.charAt(j-1)){
                    temp[j] = dp[j-1] + dp[j];
                }
                else{
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }
        return dp[t.length()];
    }

 
}
class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];

        for (int j = 1; j <= word2.length(); j++) {
            dp[j] = j;
        }

            dp[0] = 0;
        

        for (int i = 1; i <= word1.length(); i++) {
            int[] temp = new int[word2.length()+1];
            temp[0]=i;

            for (int j = 1; j <= word2.length(); j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                      temp[j] = dp[j - 1];
                }
                else{
                int insert = temp[j-1] + 1;

                int delete = dp[j] + 1;
                int replace = dp[j-1] + 1;

                int ans = Math.min(insert, delete);
                 temp[j] = Math.min(ans, replace);
                }

              
            }
              dp = temp;
        }

        return dp[ word2.length()];
    }

    public int find(int i, int j, String s1, String s2, Integer[][] dp) {

       

        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = find(i - 1, j - 1, s1, s2, dp);
        }
        int insert = find(i, j - 1, s1, s2, dp) + 1;

        int delete = find(i - 1, j, s1, s2, dp) + 1;
        int replace = find(i - 1, j - 1, s1, s2, dp) + 1;

        int ans = Math.min(insert, delete);
        return dp[i][j] = Math.min(ans, replace);

    }
}
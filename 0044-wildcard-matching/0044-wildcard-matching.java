class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = false;
                }

                else if (i == 0) {

                    dp[i][j] = (p.charAt(j - 1) == '*') && (dp[0][j - 1]);

                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }

                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean match(int i, int j, String s, String p, Boolean[][] dp) {

        boolean ans = false;

        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0) {
            return false;
        }
        if (i == 0) {
            while (j > 0 && p.charAt(j - 1) == '*') {
                j--;
            }
            return j == 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            ans = match(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j - 1) == '*') {
            ans = match(i, j - 1, s, p, dp) || match(i - 1, j, s, p, dp);
        }

        return dp[i][j] = ans;
    }
}
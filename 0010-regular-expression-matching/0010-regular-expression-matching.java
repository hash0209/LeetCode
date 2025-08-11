class Solution {
    public boolean isMatch(String s, String p) {

        Integer[][] dp = new Integer[s.length() + 1][p.length() + 1];
        return match(s.length(), p.length(), s, p, dp);
    }

    public boolean match(int i, int j, String s, String p, Integer[][] dp) {
        if (i == 0 & j == 0) {
            return true;
        }
        if (j == 0) {
            return false;
        }

        if (i == 0) {
            while (j >= 1 && p.charAt(j - 1) == '*') {
                j = j - 2;
            }
            return (j == 0);

        }
        if (dp[i][j] != null) {
            return (dp[i][j] == 1);
        }

        boolean res = false;

        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {

            res = match(i - 1, j - 1, s, p, dp);

        } else if (p.charAt(j - 1) == '*') {
            boolean ans1 = match(i, j - 2, s, p, dp);

            boolean ans2 = false;

            if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {

                ans2 = match(i - 1, j, s, p, dp);
            }

            res = ans1 || ans2;
        }
        if (res) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }
        return res;
    }
}
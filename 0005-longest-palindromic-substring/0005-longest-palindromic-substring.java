class Solution {
    public String longestPalindrome(String s) {

        int max = 0;
        int start = 0;

        Integer[][] dp = new Integer[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < s.length(); j++) {

                if (dp[i][j] != null) {
                    if (dp[i][j] == 1) {
                        int len = j - i + 1;
                        if (len > max) {
                            max = len;
                            start = i;
                        }
                    }
                }

                if (isPalindrome(i, j, s)) {

                    dp[i][j] = 1;

                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        start = i;
                    }

                }
                else{
                    dp[i][j] =0;
                }
            }
        }

        return s.substring(start, start + max);
    }

    public boolean isPalindrome(int left, int right, String s) {

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
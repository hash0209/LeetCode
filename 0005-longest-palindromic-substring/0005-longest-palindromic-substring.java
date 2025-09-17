class Solution {
    public String longestPalindrome(String s) {

        int maxlen = 0;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String l = check(s, i, i + 1);
            String r = check(s, i - 1, i + 1);

            if (l.length() > r.length() && maxlen < l.length()) {
                maxlen = l.length();
                ans = l;
            } else {
                if (maxlen < r.length()) {
                    maxlen = r.length();
                    ans = r;
                }
            }
        }
        return ans;

    }

    public String check(String s, int start, int end) {
        if (start < 0 || end >= s.length()) {
            return s.substring(start + 1, end);
        }

        if (s.charAt(start) != s.charAt(end)) {
            return s.substring(start + 1, end);
        }

        return check(s, start - 1, end + 1);
    }
}
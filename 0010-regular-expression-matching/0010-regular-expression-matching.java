class Solution {
    public boolean isMatch(String s, String p) {
        return match(s.length(), p.length(), s, p);
    }

    public boolean match(int i, int j, String s, String p) {
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

        boolean res = false;

        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
            res = match(i - 1, j - 1, s, p);
        } else if (p.charAt(j - 1) == '*') {
            boolean ans1 = match(i, j - 2, s, p);

            boolean ans2 = false;

            if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {

                ans2 = match(i - 1, j, s, p);
            }

            res = ans1 || ans2;
        }
        return res;
    }
}
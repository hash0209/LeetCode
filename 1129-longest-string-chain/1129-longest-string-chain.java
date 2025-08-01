class Solution {
    public int longestStrChain(String[] words) {

        int[] dp = new int[words.length];

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Arrays.fill(dp, 1);

        int maxf = 1;

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < i; j++) {

                if (isValid(words[i], words[j])) {

                    int length = dp[j] + 1;
                    if (dp[i] < length) {
                        dp[i] = length;
                        
                    }

                }

            }
            maxf = Math.max(maxf, dp[i]);
        }

        return maxf;

    }

    public Boolean isValid(String curr, String prev) {
        if (curr.length() != prev.length() + 1) {
            return false;
        }

        int diff = 0;
        int left = 0;
        int right = 0;

        while (left < curr.length() && right < prev.length()) {

            if (curr.charAt(left) == prev.charAt(right)) {
                left++;
                right++;
            } else {
                diff++;
                if (diff > 1) {
                    return false;
                }
                left++;
            }

        }
        return true;

    }

}
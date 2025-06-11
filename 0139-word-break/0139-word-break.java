import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Faster lookup
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, 0, wordSet, memo);
    }

    private boolean dfs(String s, int idx, Set<String> wordSet, Boolean[] memo) {
        if (idx == s.length()) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String prefix = s.substring(idx, end);
            if (wordSet.contains(prefix) && dfs(s, end, wordSet, memo)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }
}
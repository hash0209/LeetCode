class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        // Frequency map of words
        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : words) targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);

        // Check each offset
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (targetMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);

                    // Shrink window if frequency exceeds target
                    while (windowMap.get(word) > targetMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // If window matches all words
                    if (right + wordLen - left == totalLen) result.add(left);

                } else {
                    // Reset window
                    windowMap.clear();
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

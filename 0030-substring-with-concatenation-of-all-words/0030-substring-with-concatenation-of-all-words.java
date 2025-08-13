class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        // Build frequency map for words
        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : words)
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);

        // Check all offsets
        
       for(int offset=0; offset < wordLen ; offset++){
            int left = offset;
            int right = offset;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (targetMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);

                    // Shrink window if word count exceeds target
                    while (windowMap.get(word) > targetMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // Check if window length matches total concatenation
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    // Reset window if word is not in target
                    windowMap.clear();
                    left = right;
                }
            }
           
        }

        return result;
    }
}

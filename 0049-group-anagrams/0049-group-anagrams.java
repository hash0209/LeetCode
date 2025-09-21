class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] freq = new int[26];
           

            for (char c : strs[i].toCharArray()) {
                freq[c - 'a']++;

            }

             StringBuilder keyBuilder = new StringBuilder();

            for (int j = 0; j < freq.length; j++) {
                keyBuilder.append(freq[j] + "#");

            }

            String key = keyBuilder.toString();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);

        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> l : map.values()) {
            res.add(l);
        }

        return res;

    }
}
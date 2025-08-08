class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        int maxlen = 0;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {

            String word = String.valueOf(arr1[i]);

            for (int j = 1; j <= word.length(); j++) {
                set.add(word.substring(0, j));
            }

        }

        for (int j = 0; j < arr2.length; j++) {

            String word = String.valueOf(arr2[j]);

            for (int i = 1; i <= word.length(); i++) {

                String prefix = word.substring(0, i);
                if (set.contains(prefix)) {
                    maxlen = Math.max(maxlen, prefix.length());
                }
            }

        }

        return maxlen;
    }

}

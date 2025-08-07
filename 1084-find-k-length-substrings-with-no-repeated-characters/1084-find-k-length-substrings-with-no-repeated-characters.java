class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {

        int l = 0;
        int r = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            while (map.containsKey(s.charAt(r))) {
                map.remove(s.charAt(l));
                l++;
            }

            map.put(s.charAt(r), r);

            if (r-l+1> k) {
                map.remove(s.charAt(l));
                l++;

            }
            if (r-l+1 == k) {
                count++;
            }

            r++;

        }
        return count;

    }
}
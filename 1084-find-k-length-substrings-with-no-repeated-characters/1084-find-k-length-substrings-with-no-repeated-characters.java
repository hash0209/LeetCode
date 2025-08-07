class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {

        int l = 0;
        int r = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            if (map.containsKey(s.charAt(r)) && l <= map.get(s.charAt(r))) {
              
                l= map.get(s.charAt(r))+1;
            }

            map.put(s.charAt(r), r);

            if (r-l+1> k) {
              
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
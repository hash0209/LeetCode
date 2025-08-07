class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {

        int l = 0;
        int r = 0;
        int count = 0;

        Map<Character, Integer> indicesMap = new HashMap<>();

        while (r < s.length()) {

            if (indicesMap.containsKey(s.charAt(r)) && l <= indicesMap.get(s.charAt(r))) {
              
                l= indicesMap.get(s.charAt(r))+1;
            }

            indicesMap.put(s.charAt(r), r);

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
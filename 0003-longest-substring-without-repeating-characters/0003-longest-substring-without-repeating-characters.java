class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        Map<Character,Integer> indicesMap = new HashMap<>();

        int maxlen =Integer.MIN_VALUE;

        int l =0; int r =0;

        while(r < s.length()){
            if(indicesMap.containsKey(s.charAt(r)) && l <= indicesMap.get(s.charAt(r))){
                   int idx = indicesMap.get(s.charAt(r));
                   l= idx+1;
            }
            indicesMap.put(s.charAt(r),r);
            maxlen = Math.max(r-l+1,maxlen);
            r++;
        }
        return maxlen;

    }
}
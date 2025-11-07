class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        Map<Character,Integer> indicesMap = new HashMap<>();

        int maxlen =Integer.MIN_VALUE;

        int l =0; int r =0;

        while(r < s.length()){
             int idx =indicesMap.getOrDefault(s.charAt(r),-1);
            if(l <= idx){
                 
                   l= idx+1;
            }
            indicesMap.put(s.charAt(r),r);
            maxlen = Math.max(r-l+1,maxlen);
            r++;
        }
        return maxlen;

    }
}
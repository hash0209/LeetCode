class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen =0;
        int l=0; int r=0;
        while(r <s.length()){

            int idx = map.getOrDefault(s.charAt(r),-1);
            if( l <= idx){
                  l = idx+1;
            }

            maxlen =Math.max(maxlen , r-l+1);
            map.put(s.charAt(r),r);
            r++;
        }

        return maxlen;
        
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l =0;
        int r= 0;

        int maxlength = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(r < s.length()){
            if(map.containsKey(s.charAt(r)) && l <= map.get(s.charAt(r))){
                l = map.get(s.charAt(r))+1;
            }

            

            map.put(s.charAt(r),r);
            maxlength= Math.max(maxlength , r-l+1);
            r ++;
        }
        return maxlength;
        
    }
}
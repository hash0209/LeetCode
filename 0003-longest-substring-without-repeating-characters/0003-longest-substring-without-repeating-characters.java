class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int r =0;

        int maxlength = 0;

        while(r < s.length()){

            while(map.containsKey(s.charAt(r))){
                map.remove(s.charAt(l));
                l++;
            }

            
           
                map.put(s.charAt(r),r);
                int len = r-l+1;
                maxlength = Math.max(maxlength , len);
                r++;


            

        }

        return maxlength;


    }
}
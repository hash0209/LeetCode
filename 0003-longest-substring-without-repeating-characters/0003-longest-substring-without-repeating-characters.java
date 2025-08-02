class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int r =0;

        int maxlength = 0;

        while(r < s.length()){

            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l){
                l= map.get(s.charAt(r))+1;
            }
            
           
                map.put(s.charAt(r),r);
                int len = r-l+1;
                maxlength = Math.max(maxlength , len);
                r++;


            

        }

        return maxlength;


    }
}
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int l =0; int r = 0; int maxlen = Integer.MIN_VALUE;

        HashMap<Character,Integer> map = new HashMap<>();

        while(r < s.length()){
            map.putIfAbsent(s.charAt(r),0);
            int f = map.get(s.charAt(r));
            map.put(s.charAt(r),f+1);
            

            while(map.size() >2){
                int f1 = map.get(s.charAt(l));
                if( f1 == 1){
                    map.remove(s.charAt(l));

                }
                else{
                    map.put(s.charAt(l),f1-1);
                }
                l++;
            }


            maxlen= Math.max(r-l+1, maxlen);
           
            r++;
        }
        return maxlen;
        
    }
}
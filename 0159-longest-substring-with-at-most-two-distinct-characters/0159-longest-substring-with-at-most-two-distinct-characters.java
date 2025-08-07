class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int l =0; int r = 0; int maxlen = Integer.MIN_VALUE;

        HashMap<Character,Integer> freqMap = new HashMap<>();

        while(r < s.length()){
            freqMap.put(s.charAt(r),freqMap.getOrDefault(s.charAt(r),0)+1);
            

            while(freqMap.size() >2){
                int f1 = freqMap.get(s.charAt(l));
                if( f1 == 1){
                    freqMap.remove(s.charAt(l));

                }
                else{
                    freqMap.put(s.charAt(l),f1-1);
                }
                l++;
            }


            maxlen= Math.max(r-l+1, maxlen);
           
            r++;
        }
        return maxlen;
        
    }
}
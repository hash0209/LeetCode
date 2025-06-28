class Solution {
    public int characterReplacement(String s, int k) {
        
        int l=0;
        int r =0;

        int mf =0;
        int ml=0;

        Map<Character,Integer> map= new HashMap<>();


        while(r< s.length()){
            int f = 1;
               if(map.containsKey(s.charAt(r))){
                int val = map.get(s.charAt(r));
              
                f = val+1;
               
               }
                map.put(s.charAt(r),f);
                mf =Math.max(mf,f);

                if((r-l+1)-mf > k){
                    int val = map.get(s.charAt(l));
                    map.put(s.charAt(l),val-1);
                    l++;
                }

            ml =Math.max((r-l+1),ml);
            r++;
        }

        return ml ;
    }
}
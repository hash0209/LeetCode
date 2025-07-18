class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int l=0; 
        int r=0; 
        long count =0;

        while(r < s.length()){
            int f =1;
            if(map.containsKey(s.charAt(r))){
                    f =  map.get(s.charAt(r)) +1;
            }
            map.put(s.charAt(r),f);

            while(map.size() >= 3){
               int val = map.get(s.charAt(l))-1;
               if(val == 0){
                map.remove(s.charAt(l));
               }
               else{
                map.put(s.charAt(l),val);
               }
               l++;
            

            }
            count += (long)(r-l+1);
            r++;
        }


        long total = ((1L * s.length()*(s.length()+1)))/2L;

        return (int)(total -count);

        
    }
}
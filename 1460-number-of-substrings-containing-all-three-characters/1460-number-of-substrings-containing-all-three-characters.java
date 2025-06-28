class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();

        long l=0; 
        long r=0; 
        long count =0;

        while(r < s.length()){
            int f =1;
            if(map.containsKey(s.charAt((int)r))){
                    f =  map.get(s.charAt((int)r)) +1;
            }
            map.put(s.charAt((int)r),f);

            while(map.size() >= 3){
               int val = map.get(s.charAt((int)l))-1;
               if(val == 0){
                map.remove(s.charAt((int)l));
               }
               else{
                map.put(s.charAt((int)l),val);
               }
               l++;
            

            }
            count += (r-l+1);
            r++;
        }


        long total = ((1L * s.length()*(s.length()+1)))/2L;

        return (int)(total -count);

        
    }
}
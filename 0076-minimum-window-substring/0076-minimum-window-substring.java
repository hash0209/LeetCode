class Solution {
    public String minWindow(String s, String t) {
        int tlen = t.length();

        int l=0;
        int r= 0;

        int minlen = Integer.MAX_VALUE;

        Map<Character,Integer> map = new HashMap<>();
        String ans="";

        

        while(r< tlen){
            int f =1;
            if(map.containsKey(t.charAt(r))){
                f =map.get(t.charAt(r))+1;
            }
            map.put(t.charAt(r),f);
            r++;
        }
        r = 0;

        int count =0;


        while(r < s.length()){
             if(map.containsKey(s.charAt(r))){
                int f = map.get(s.charAt(r));

                if(f > 0){
                    count++;
                }
                map.put(s.charAt(r),f-1);
             }

             
             while(count == tlen){
                if(minlen > r-l+1){
                    minlen = r-l+1;
                    ans = s.substring(l,r+1);
                }
                if(map.containsKey(s.charAt(l))){
                    int f =map.get(s.charAt(l));
                    if(f >=0){
                       count--;
                    }
                    map.put(s.charAt(l),f+1);
                }
                l++;
             }
             r++;
        }

        return ans;
    }
}
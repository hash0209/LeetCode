class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l =0; 
        int r =0; 

        int max = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        char[] c =s.toCharArray();

        while(r < c.length){
            if(map.containsKey(c[r]) && map.get(c[r]) >=l){
               l = map.get(c[r]) +1;
               
            }
            else{
                map.put(c[r],r);
                max =Math.max(max,r-l+1);
                r++;
            }
        }

        return max;
        
    }
}
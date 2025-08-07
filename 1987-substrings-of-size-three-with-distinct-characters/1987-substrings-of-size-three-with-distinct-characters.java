class Solution {
    public int countGoodSubstrings(String s) {
        int count= 0;
        char[] c = s.toCharArray();
        
        for (int i =0; i < c.length-2 ; i++){

            if(c[i]!=c[i+1] && c[i+1]!=c[i+2] && c[i] !=c[i+2]){
                count++;
            }

        }

        return count  ;
    }
}
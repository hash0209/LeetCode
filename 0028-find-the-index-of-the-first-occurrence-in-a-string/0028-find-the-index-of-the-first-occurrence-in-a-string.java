class Solution {
    public int strStr(String haystack, String needle) {

         int end = haystack.length()-needle.length();

        for(int i = 0; i <= end  ;i++){
             if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
             }

        }
        return -1;
        
    }
}
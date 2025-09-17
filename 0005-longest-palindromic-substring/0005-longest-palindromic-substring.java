class Solution {
    public String longestPalindrome(String s) {

        
        int start =0;
        int end=0;

        for (int i = 0; i < s.length(); i++) {
            int l = check(s, i, i + 1);
            int r = check(s, i - 1, i + 1);

            int len = Math.max(l,r);
            if(len > end-start+1){
                  start = i -(len-1)/2;
                  end =i+(len)/2;

            }
        }

            
        return s.substring(start,end+1);

    }

    public int check(String s, int start, int end) {
        if (start < 0 || end >= s.length()) {
            return end-start-1;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return end-start-1;
        }

        return check(s, start - 1, end + 1);
    }
}
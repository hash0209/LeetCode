class Solution {
    public String longestPalindrome(String s) {

        int max = 0;
        int start = 0;

        Integer[][] dp = new Integer[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(i, j, s , dp) == 1) {

                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        start = i;
                    }

                }

            }
        }

        return s.substring(start, start + max);
    }

    public int isPalindrome(int left, int right, String s ,Integer[][] dp) {

        if(left > right){
            return 1;
        }
        if(dp[left][right]!=null){
             return dp[left][right];
        }

        if(s.charAt(left) ==s.charAt(right)){
           return dp[left][right] = isPalindrome(left+1 , right-1 ,s ,dp);
        }

        return dp[left][right]=0;

      

        
       
    }
}
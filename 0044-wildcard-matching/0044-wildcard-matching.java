class Solution {
    public boolean isMatch(String s, String p) {
        Integer[][] dp = new Integer[s.length()+1][p.length()+1];
       return find(s.length(),p.length(),s,p  , dp);
    }

    public boolean find(int i, int j, String s, String p , Integer[][] dp) {

        boolean ans = false;

        if (i == 0 && j == 0) {
            return true;
        }

        if (j == 0) {
            return false;
        }

        if (i == 0) {

            while (j > 0) {
                if (p.charAt(j - 1) == '*') {
                    j--;
                } else {
                    return false;
                }
            }
            return true;
            

        }
        if(dp[i][j]!=null){
            return dp[i][j] == 1 ? true : false;
        }

        if (p.charAt(j - 1) == s.charAt(i - 1)) {
            ans = find(i - 1, j - 1, s, p,dp);
        }

     else   if (p.charAt(j - 1)=='?') {
            ans = find(i - 1, j - 1, s, p , dp);
        }

      else  if (p.charAt(j - 1) == '*' ){
            boolean res = false;

            for (int t = i; t >= 0; t--) {
                if (res) {
                    break;
                }
                res = find(t , j-1, s, p , dp);
            }
          ans =res;

        }
        if(ans){
            dp[i][j] = 1;
        }
        else{
            dp[i][j] =0;
        }

        return ans;

    }
}
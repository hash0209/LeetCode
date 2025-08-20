class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return match(s.length(),p.length(),s,p ,dp);
    }
    public boolean match(int i , int j , String s ,  String p , Boolean[][] dp){

        boolean ans = false;

        if(i == 0 && j == 0){
            return true;
        }
        if( j== 0){
            return false;
        }
        if(i == 0){
            while( j >0 && p.charAt(j-1) == '*'){
                j--;
            }
            return j == 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
            


            if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                ans = match(i-1 , j-1 , s , p , dp);
            }
            else if(p.charAt(j-1) == '*'){
                ans = match(i , j-1 , s , p,dp) || match(i-1,j,s,p,dp);
            }

            return dp[i][j] = ans;
    }
}
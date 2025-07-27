class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        return find(s.length(),t.length(),s,t,dp);
    }

    public int find(int i , int j , String s , String t , Integer[][] dp ){
        if(j==0){
            return 1;
        }
        if(i==0){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(s.charAt(i-1)== t.charAt(j-1)){
            return  dp[i][j] = find(i-1,j-1,s,t,dp) + find(i-1,j,s,t,dp);
        }
        return  dp[i][j] =find(i-1,j,s,t,dp);
    }
}
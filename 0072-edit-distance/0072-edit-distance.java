class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        return find(word1.length(),word2.length(),word1,word2 , dp);
    }

    public int find(int i , int j , String s1 , String s2 , Integer[][] dp){
        
        if(i== 0){
            return j ;
        }

        if(j == 0){
            return i ;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }



         if(s1.charAt(i-1) == s2.charAt(j-1)){
              return dp[i][j] = find(i-1, j-1 , s1,s2,dp);
         }
         int insert = find(i,j-1,s1,s2,dp)+1;

         int delete = find(i-1 , j , s1, s2,dp) +1 ;
         int replace = find(i-1 ,j-1,s1,s2,dp) +1;

         int ans = Math.min(insert , delete);
         return dp[i][j]=  Math.min(ans , replace);
        
    }
}
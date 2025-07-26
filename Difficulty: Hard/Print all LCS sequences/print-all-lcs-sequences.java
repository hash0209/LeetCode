// User function Template for Java

class Solution {
    public List<String> allLCS(String s1, String s2) {
        // Code here
        
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        
        for(int i = 1;i <= s1.length() ; i++){
            
            for(int j =1 ; j <= s2.length() ; j++){
                
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        
        TreeSet<String>[][] memo = new TreeSet[s1.length()+1][s2.length()+1];
        
        
        
        
        TreeSet<String> ans = dfs(s1.length(),s2.length(),s1,s2, dp , memo);
        return new ArrayList<String>(ans);
        
        
        
        
    }
    
    
    
    public TreeSet<String> dfs (int i , int j , String s1 , String s2 , int[][] dp , TreeSet<String>[][] memo ){
        
        TreeSet<String> ans = new TreeSet<>();
        
        if(i == 0 || j == 0){
            ans.add("");
            return ans ;
        }
        
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        
        
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            TreeSet<String> temp = dfs(i-1,j-1,s1,s2,dp ,memo);
            
            for(String s : temp){
                ans.add(s+ s1.charAt(i-1));
            }
        }
        else{
            if(dp[i-1][j] == dp[i][j]){
                ans.addAll(dfs(i-1,j,s1,s2,dp,memo));
            }
            if(dp[i][j-1] ==  dp[i][j]){
                ans.addAll(dfs(i,j-1,s1,s2,dp,memo));
            }
        }
        
        return memo[i][j] =  ans;
    }
}
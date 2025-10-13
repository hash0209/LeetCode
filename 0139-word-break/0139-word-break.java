class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return find(0,s,new HashSet<>(wordDict) , dp);
    }

    public boolean find(int i , String s , Set<String> wordDict , Boolean[] dp){
        if(i == s.length()){
            return true;
        }
        if(null != dp[i]){
            return dp[i];
        }

        for(int idx =i+1; idx <= s.length() ; idx++){
            if(wordDict.contains(s.substring(i,idx))){
                  if(find(idx,s,wordDict,dp)){
                    return dp[i] =  true;
                  }
            }
        }
        return dp[i] =false;
    }
}
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return find(0,dp, s);
    }

    public int find(int i , int[] dp , String s){

        int ways =0;
        if(i == s.length()){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

       



        ways+= find(i+1,dp, s);

        if(i+1 < s.length()){
            String sub = s.substring(i,i+2);
           
                 int num = Integer.valueOf(sub);
                 if(num >= 1 && num <= 26){
            
            ways+= find(i+2,dp ,s);
                 }
        }
        return dp[i] = ways;
        

        
    }


}
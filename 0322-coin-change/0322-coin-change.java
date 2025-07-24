class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }

        int[][] dp = new int[coins.length][amount+1];
        for(int[] row :dp){
            Arrays.fill(row,-1);
        }
        int ans = find(coins.length-1, amount , coins ,dp);
                 return (ans == Integer.MAX_VALUE )?-1 : ans;
    }

    public int find(int idx, int amt, int[] coins , int[][] dp) {
        if(amt == 0){
            return 0;
        }
        if (idx == 0) {

            if(amt >= coins[0] && (amt % coins[0] )==0){
                return (amt/coins[0]);
            }
            return Integer.MAX_VALUE;
           
          
        }
        if(dp[idx][amt]!=-1){
            return dp[idx][amt];
        }

        int pick = Integer.MAX_VALUE;

        if (amt >= coins[idx]) {
            pick = find(idx, amt - coins[idx], coins , dp);
            pick = (pick==Integer.MAX_VALUE)? pick : pick+1;
        }

        int notPick = find(idx - 1, amt ,  coins , dp);

        return dp[idx][amt] = Math.min(pick,notPick);

    }
}
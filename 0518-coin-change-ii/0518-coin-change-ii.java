class Solution {
    public int change(int amount, int[] coins) {


        int[][] dp = new int[coins.length][amount+1];

        

        for(int idx = 0; idx < coins.length ; idx++){
            dp[idx][0] = 1;
        }

        for(int amt =1 ; amt <= amount ; amt++){
            if (amt >= coins[0] && (amt% coins[0] == 0)){
                dp[0][amt] =1;
            }
        }


        for(int idx =1 ; idx < coins.length ; idx++){

            for(int amt =1 ; amt <= amount ; amt++){

                int pick = (amt >= coins[idx]) ? dp[idx][amt-coins[idx]]:0;

                int notpick = dp[idx-1][amt];

                dp[idx][amt] = pick +notpick;
            }
        }



        return dp[coins.length-1][amount];
    }


    public int find(int idx , int amt , int[] coins){
        if(amt == 0){
            return 1;
        }

        if(idx == 0){
            if (amt >= coins[0] && (amt% coins[0] == 0)){
                return 1;
            }
            return 0;
        }



        int pick = (amt >= coins[idx]) ? find(idx,amt-coins[idx],coins) : 0;

        int notpick = find(idx-1 , amt , coins);


        return pick+notpick;
    }
}
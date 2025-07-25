class Solution {
    public int change(int amount, int[] coins) {


        int[] dp = new int[amount+1];

        

      
            dp[0] = 1;
        

        for(int amt =1 ; amt <= amount ; amt++){
            if (amt >= coins[0] && (amt% coins[0] == 0)){
                dp[amt] =1;
            }
        }


        for(int idx =1 ; idx < coins.length ; idx++){
            int[] temp = new int[amount+1];
            temp[0] =1;

            for(int amt =1 ; amt <= amount ; amt++){

                int pick = (amt >= coins[idx]) ? temp[amt-coins[idx]]:0;

                int notpick = dp[amt];

                temp[amt] = pick +notpick;
            }
            dp=temp;
        }



        return dp[amount];
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
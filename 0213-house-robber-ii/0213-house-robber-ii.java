class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int [][] dp1 = new int[nums.length][2];
   //last picked 

        dp1[0][0] =  0;
        dp1[0][1] = 0;

        for(int idx =1; idx < nums.length-1 ; idx ++){
                for(int p =0 ; p <=1 ; p++){

                    
                    int pick = Integer.MIN_VALUE; 

                    if(p == 1){
                       pick = dp1[idx-1][0] + nums[idx];

                       
                    }

                  //  int notPick = Integer.MIN_VALUE;

                   
                    int notPick = dp1[idx-1][1];

                    dp1[idx][p] = Math.max(pick,notPick);
                }
        }

        int ans11 = dp1[nums.length-2][0] + nums[nums.length-1];

        

        //not picked

        int [][] dp2 = new int[nums.length][2];

        dp2[0][0] =  0;
        dp2[0][1] = nums[0];

        for(int idx =1; idx < nums.length-1 ; idx++){
                for(int p =0 ; p <=1 ; p++){
                    int pick = Integer.MIN_VALUE; 

                    if(p == 1){
                       pick = dp2[idx-1][0] + nums[idx];

                       
                    }

                  //  int notPick = Integer.MIN_VALUE;

                   
                    int notPick = dp2[idx-1][1];

                    dp2[idx][p] = Math.max(pick,notPick);
                }
        }

        int ans22 = dp2[nums.length-2][1];

        return Math.max(ans11,ans22);



        

    }

}
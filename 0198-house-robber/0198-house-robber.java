class Solution {
    public int rob(int[] nums) {
      
        int prev = nums[0] ; int prev2 = 0;

        for(int idx =1 ; idx < nums.length ; idx++){

               int pick = prev2 + nums[idx] ;

               int notpick =prev;

               prev2 = prev ;
               prev = Math.max(pick,notpick);

        }

        return prev;
    }
}
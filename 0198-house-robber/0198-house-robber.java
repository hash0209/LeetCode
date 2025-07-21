class Solution {
    public int rob(int[] nums) {

       

        int prev = nums[0];
        int prev2 = 0;
      
        for (int idx = 1; idx < nums.length; idx++) {

            int pick = nums[idx];

            if (idx - 2 >= 0) {

                pick = pick + prev2;
            }

            int notPick = 0;

            if (idx - 1 >= 0) {

                notPick = prev;
            }

            prev2 = prev ;

            prev = Math.max(pick, notPick);
        }

        return prev;

    }

}
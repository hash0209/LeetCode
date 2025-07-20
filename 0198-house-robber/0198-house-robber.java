class Solution {
    public int rob(int[] nums) {

        

        int[] cdp = new int[2];

        cdp[0] =0;
        cdp[1]=nums[0];

        

        for (int idx = 1; idx < nums.length; idx++) {

          int[] temp = new int[2];

            for (int p = 0; p <= 1; p++) {
                int pick = Integer.MIN_VALUE;

                if (p == 1) {
                    pick = cdp[0] + nums[idx];
                }

                int notPick = cdp[1];

                temp[p] = Math.max(pick, notPick);
               
            }

            cdp = temp;

        }

        return Math.max(cdp[0],cdp[1]);

    }

}
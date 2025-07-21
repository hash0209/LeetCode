class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robb(nums, 0, nums.length - 2), robb(nums, 1, nums.length - 1));
    }

    public int robb(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev = nums[start];

        for (int idx = start + 1; idx <= end; idx++) {

            int pick = nums[idx];

           // if (idx - 2 >= 0) {
                pick = pick + prev2;
           // }

            int notPick = 0;

           // if (idx - 1 >= 0) {

                notPick = prev;
          //  }

            prev2 = prev;
            prev = Math.max(pick, notPick);

        }

        return prev;

    }
}
class Solution {
    public int jump(int[] nums) {
        int[] jumpCount = new int[nums.length];

        jumpCount[nums.length - 1] = 0;

        int dest = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxlength = nums[i];

            if (i + maxlength >= dest) {
                jumpCount[i] = 1;
            } else {
                
                int minJump = Integer.MAX_VALUE;

                while (maxlength > 0) {
                    if (jumpCount[i + maxlength] != Integer.MAX_VALUE) {
                        minJump = Math.min(minJump, 1 + jumpCount[i + maxlength]);
                      
                    }
                      maxlength--;
                }

                jumpCount[i] = minJump;
            }
        }

        return jumpCount[0];
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;

        int r = 0;

        int count = 0;
        int maxlength = 0;

        while (r < nums.length) {

            if (nums[r] == 0) {
                count++;
               
            }

             if (count > k) {

                   // l++;
                    if (nums[l] == 0) {
                       
                        count--;
                    }
                    l++;
                }

            if (count <= k) {
                maxlength = Math.max(r - l + 1, maxlength);
            }

            r++;

        }

        return maxlength;
    }
}
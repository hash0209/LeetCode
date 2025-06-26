class Solution {
    public int totalFruit(int[] fruits) {

        int[] nums = fruits;
        Map<Integer, Integer> map = new HashMap<>();

        int first = -1;
        int second = -1;

        int firstcount = 0;
        int secondcount = 0;

        int max = 0;
        int l =0;
        int r =0;

        while (r < fruits.length) {

            if (nums[r] == first) {
                firstcount++;
                r++;
            } else if (nums[r] == second) {
                secondcount++;
                r++;
            } else if (first == -1) {
                first = nums[r];
                firstcount++;
                r++;

            } else if (second == -1) {
                second = nums[r];
                secondcount++;
                r++;
            } else {

                max = Math.max(max, firstcount + secondcount);

                while (first != -1 && second != -1) {
                    if (nums[l] == first) {
                        firstcount--;

                    } else {
                        secondcount--;
                    }

                    if (firstcount == 0) {
                        first = -1;
                    }
                    if (secondcount == 0) {
                        second = -1;
                    }
                    l++;
                }

            }

        }
        max = Math.max(max, firstcount + secondcount);
        return max;
    }
}
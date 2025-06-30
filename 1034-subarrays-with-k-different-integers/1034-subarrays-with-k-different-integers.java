class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums, k) - find(nums, k - 1);
    }

    public int find(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {

            int f = 1;
            if (map.containsKey(nums[r])) {
                f = map.get(nums[r]) + 1;

            }
            map.put(nums[r], f);

            while (map.size() > k) {
                int val = map.get(nums[l]) - 1;
                if (val == 0) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], val);
                }

                l++;
            }

            if (map.size() <= k) {
                count += r - l + 1;
            }
            r++;
        }

        return count;

    }
}
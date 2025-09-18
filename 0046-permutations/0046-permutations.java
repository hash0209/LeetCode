class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res =new ArrayList<>();
        find(nums , new boolean[nums.length] , new ArrayList<>() , res);
        return res;

    }

    public void find(int[] nums, boolean[] taken, List<Integer> ds, List<List<Integer>> res) {
        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (!taken[idx]) {
                taken[idx] = true;
                ds.add(nums[idx]);
                find(nums, taken, ds, res);
                ds.remove(ds.size() - 1);
                taken[idx] = false;
            }

        }
    }
}
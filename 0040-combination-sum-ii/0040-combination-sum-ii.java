class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates.length - 1, target, candidates, res, new ArrayList<>());
        return res;
        

    }

    public void find(int idx, int target, int[] nums, List<List<Integer>> res, List<Integer> ds) {
        if (target == 0) {

            res.add(new ArrayList<>(ds));
            return;
        }
        if (idx == -1) {
            return;
        }

        if (target >= nums[idx]) {
            ds.add(nums[idx]);
            find(idx - 1, target - nums[idx], nums, res, ds);
            ds.remove(ds.size() - 1);
        }
        idx = idx - 1;

        while (idx >= 0 && nums[idx] == nums[idx + 1]) {
            idx--;
        }

        find(idx, target, nums, res, ds);
    }
}
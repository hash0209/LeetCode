class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

         find(candidates.length - 1, candidates, target, new ArrayList<>() ,res);
         return res;
    }

    public void find(int idx, int[] nums, int target, List<Integer> ds ,  List<List<Integer>> res) {

        
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return ;
            
        }
        if (idx == -1) {
           return ;
        }

        if (target >= nums[idx]) {
            ds.add(nums[idx]);
            find(idx, nums, target - nums[idx], ds,res);
            ds.remove(ds.size() - 1);

        }

         find(idx - 1, nums, target, ds,res);
       
    }
}
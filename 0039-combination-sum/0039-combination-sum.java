class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return find(candidates.length-1 , candidates,target , new ArrayList<>());
    }

    public List<List<Integer>>  find(int idx , int[] nums , int target , List<Integer> ds){

        List<List<Integer>> res = new ArrayList<>();
        if(target == 0){
             res.add(new ArrayList<>(ds));
             return res;
        }
        if(idx == -1){
            return res;
        }



       
        if(target >= nums[idx]){
            ds.add(nums[idx]);
            res.addAll(find(idx,nums,target-nums[idx],ds));
            ds.remove(ds.size()-1);

        }

         res.addAll(find(idx-1,nums,target,ds));
         return res;
    }
}
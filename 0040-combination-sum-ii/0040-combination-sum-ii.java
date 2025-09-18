class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        find(candidates.length -1 , candidates,target,res,new ArrayList<>());
        return res;


        
    }


    public void find(int idx , int[] nums , int target , List<List<Integer>> res , List<Integer> ds){
         if(target == 0){
             res.add(new ArrayList<>(ds));
             return;
         }

         if(idx < 0){
            return ;
         }

         if(nums[idx] <= target){
            ds.add(nums[idx]);
            find(idx-1 , nums , target-nums[idx],res, ds);
            ds.remove(ds.size()-1);
         }

         idx = idx-1;
         while(idx >=0 && nums[idx] == nums[idx+1]){
            idx--;
         }
         find(idx , nums , target , res , ds);
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
         find(0,nums,list , new ArrayList<>());
         return list;
        
        
    }

    public void find(int idx , int[] nums , List<List<Integer>> list ,List<Integer> ds){
         if(idx == nums.length){
            list.add(new ArrayList<>(ds));
            return;
         }

          ds.add(nums[idx]);
          find(idx+1,nums,list,ds);
          ds.remove(ds.size()-1);
          find(idx+1,nums,list,ds);
    }
}
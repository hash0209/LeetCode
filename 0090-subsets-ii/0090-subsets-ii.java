class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return find(0 , nums , new ArrayList<Integer>());
    }

    public List<List<Integer>> find(int idx , int[] nums , List<Integer> ds){

        List<List<Integer>> res = new ArrayList<>();
        if(idx == nums.length){
              res.add(new ArrayList<>(ds));
              return res;
        }


        ds.add(nums[idx]);


        res.addAll(find(idx+1, nums , ds));

        ds.remove(ds.size()-1);
        idx =idx+1;
        while(idx < nums.length && nums[idx]==nums[idx-1]){
            idx++;
        }

      
           res.addAll(find(idx , nums,ds));
        

        return res;
        
    }
}
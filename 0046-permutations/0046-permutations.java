class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(nums,res,new ArrayList<>()  , new boolean[nums.length]);
        return res;
    }

    public void find(int[] nums , List<List<Integer>> res , List<Integer> path , boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i =0; i < nums.length ; i++){
                if(used[i]){
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                find(nums , res , path , used);
                used[i] =false;
                path.remove(path.size()-1);
        }
        
    }
}
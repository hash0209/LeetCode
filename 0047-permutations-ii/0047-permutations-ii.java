class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         Arrays.sort(nums);
         find(nums , new ArrayList<>(),res, new boolean[nums.length]);
         return res;

        
        
    }

    public void find(int[] nums , List<Integer> path , List<List<Integer>> res , boolean[] choosen){

        if(path.size() == nums.length){
          
              res.add(new ArrayList<>(path));
              return ;
        }



        int idx =0;
        while(idx < nums.length){
             if(choosen[idx]){
                idx++;
             }
             else{

             choosen[idx] = true;
             path.add(nums[idx]);
             find(nums,path,res,choosen);
             path.remove(path.size()-1);
             choosen[idx] = false;
             idx++;
             while(idx < nums.length && nums[idx] == nums[idx-1]){
                idx++;
             }
             }

        }

    }
}
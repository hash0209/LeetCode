class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return gen(nums.length-1 , new ArrayList<Integer>()  , nums);

    }


    public List<List<Integer>> gen(int index , List<Integer> ds  , int[] nums){

        List<List<Integer>> ans = new ArrayList<>();
        if(index == 0){

           

                ds.add(nums[0]);
                ans.add(new ArrayList<>(ds));

                ds.remove(ds.size()-1);

                ans.add(new ArrayList<>(ds));

                return ans;
        }



        ds.add(nums[index]);
         
         

        List<List<Integer>> list1 = gen(index-1,ds,nums);

        ds.remove(ds.size()-1);

        List<List<Integer>> list2 = gen(index-1,ds,nums);

        ans.addAll(list1);
        ans.addAll(list2);
        return ans;


    }
}
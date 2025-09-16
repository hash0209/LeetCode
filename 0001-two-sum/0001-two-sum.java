class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer,Integer> map = new HashMap<>();
        

       for(int i =0; i < nums.length ; i++){
              int idx = map.getOrDefault(target-nums[i],-1);
              if(idx!=-1){
                ans[0] =i;
                ans[1] =idx;
                break;
              }
        map.put(nums[i],i);
       }

       return ans;


}
}
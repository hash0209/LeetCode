class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0; i <= nums.length-3 ; i++){
            if(i !=0 && nums[i] == nums[i-1]){
                continue;
            }
           

                int k = i+1;
                int l = nums.length-1;

                while(k < l){

                int sum = nums[i]+nums[k]+nums[l];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[k],nums[l]));
                    k++;
                    while(k < nums.length && nums[k]==nums[k-1]){
                        k++;
                    }
                    l--;
                    while(l >= 0 && nums[l] == nums[l+1]){
                        l--;
                    }
                }
                else if(sum > 0){
                    l--;
                }
                else{
                    k++;
                }
            }
            
        }

        return res;
        
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i <  nums.length ; i ++){

            if(i > 0  && nums[i] == nums[i-1]){
                    continue;
            }
            int sum = nums[i];

            int j = i+1;

            int k = nums.length-1;

            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;

                    while( j < nums.length && nums[j] == nums[j-1] ){
                        j++;
                    }
                    k--;

                    while(k >= 0 && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }
                else{
                    j++ ;
                }
            }
        }
        return ans; 



        
    }
}
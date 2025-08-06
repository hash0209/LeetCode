class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = 0;
        

        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length ; i ++){

            int j = i+1;
            int k = nums.length-1;

            while(j < k ){

                int sum = nums[i]+nums[j] + nums[k];

                int d = Math.abs(target-sum);

                if(d == 0){
                    return sum ;
                }

                if(d < diff){
                    diff = d;
                    ans = sum ;
                }

                if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
                

            }





        }
        return ans;
    }
}
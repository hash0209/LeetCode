class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int d =Integer.MAX_VALUE;
        int sum =0;


        for(int i =0; i < nums.length-1 ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }

            int j =i+1;
            int k = nums.length-1;

            while(j < k){
                int s = nums[i]+nums[j]+nums[k];
                if(s== target){
                    return s;
                }

                int d1 = Math.abs(target-s);
                if(d1 < d){
                    d =d1;
                    sum = s;
                }

                if(s > target){
                    k--;
                }
                else{
                    j++;
                }

                
            }


        }

        return sum ; 






    }
}
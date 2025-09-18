class Solution {
    public int firstMissingPositive(int[] nums) {

        int idx = 0 ;
        while(idx < nums.length){
            if(nums[idx] <= 0 || nums[idx] > nums.length || idx== nums[idx] -1 || nums[nums[idx]-1] == nums[idx] ){
                idx++;
            }
            else{
                int correctidx = nums[idx]-1;
                int temp = nums[correctidx];
                nums[correctidx] =nums[idx];
                nums[idx] = temp;
            }


        }

         idx =0;

        while(idx < nums.length && nums[idx] == idx+1){
            idx++;
        }

        return idx+1;


        
    }
}
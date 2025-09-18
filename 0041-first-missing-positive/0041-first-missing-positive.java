class Solution {
    public int firstMissingPositive(int[] nums) {

        int idx = 0 ;
        while(idx < nums.length){
            int correctidx = nums[idx]-1;
            if(nums[idx] <= 0 || nums[idx] > nums.length || idx== nums[idx] -1 || nums[correctidx] == nums[idx] ){
                idx++;
            }
            else{
                
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
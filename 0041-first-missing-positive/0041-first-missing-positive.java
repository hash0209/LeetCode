class Solution {
    public int firstMissingPositive(int[] nums) {

        int idx = 0;

        while(idx < nums.length){
             int correctIdx =nums[idx]-1;
            if(nums[idx] > nums.length || nums[idx] <= 0 || nums[idx] == nums[correctIdx] ){
                idx++;
            }
            else{
                int temp = nums[idx];
                
                nums[idx] =nums[correctIdx];
                nums[correctIdx] = temp ;
            }
        }

        


        for(int i = 0; i < nums.length ; i++){
            if(nums[i]!=i+1){
                return i+1;
            }
          
        }
        return nums.length+1;
        
    }
}
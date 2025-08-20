class Solution {
    public int firstMissingPositive(int[] nums) {

        int idx = 0;

        while(idx < nums.length){
            if(nums[idx] > nums.length || nums[idx] <= 0 || nums[idx] == nums[nums[idx]-1] ){
                idx++;
            }
            else{
                int temp = nums[idx];
                int idx2 = nums[idx]-1; 
                nums[idx] =nums[nums[idx]-1];
                nums[idx2] = temp ;
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
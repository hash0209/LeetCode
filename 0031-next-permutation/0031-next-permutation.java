class Solution {
    public void nextPermutation(int[] nums) {

        int idx = -1;
        

        for(int i =0; i < nums.length-1 ; i++){
            if(nums[i] < nums[i+1]){
                idx = i;
                
            }
        }

        if(idx!=-1){
            
            int correctidx = idx+1;
            for(int i =idx+1; i < nums.length ; i++){
                 if(nums[idx] < nums[i] && nums[correctidx] >= nums[i]){
                     correctidx = i;
                 }
            }

            int temp = nums[idx];
            nums[idx]= nums[correctidx];
            nums[correctidx] =temp;
        }

        idx = idx+1;

        int r = nums.length-1;

        while(idx < r){
            int temp = nums[idx];
            nums[idx]= nums[r];
            nums[r] =temp;
            idx++;
            r--;

        }


        
    }
}
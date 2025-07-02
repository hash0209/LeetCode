class Solution {
    public boolean canJump(int[] nums) {
       int nearidx =nums.length-1;
      for(int i = nums.length-2; i >= 1 ;i--){
           int maxJumps = nums[i];
           if(i+maxJumps >= nearidx){
            nearidx = i;
           }
       }

       if(nums[0] >= nearidx){
        return true;
       }
       else{
        return false;
       }

    }
}
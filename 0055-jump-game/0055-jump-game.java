class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length ==1){
            return true;
        }
        boolean[] arr = new boolean[nums.length];


        int indexToReach = nums.length-1;


        for(int i =  nums.length-2 ; i >= 0; i--){
              int maxJumps = nums[i];

              int jump=1;
              boolean canReach = false;

              while(jump <= maxJumps){

                   if(i+jump > indexToReach){
                    break;
                   }
                  else if(i+jump == indexToReach){
                    canReach=true;
                    break;
                   }
                   else if(arr[i+jump] == true){
                    canReach=true;
                    break;
                   }
                   jump++;
              }


              arr[i] = canReach;
        }

        return arr[0];
    }
}
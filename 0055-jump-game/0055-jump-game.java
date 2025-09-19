class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;

        int destidx = n-1;
        for(int i =n-2; i >= 1; i-- ){
            if(nums[i]+i >= destidx){
                destidx =i;
            }
        }


        return (nums[0] >= destidx);

        
        
    }
}
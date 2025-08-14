class Solution {
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-2),rob(nums , 1 , nums.length-1));
    }

    public int rob(int[] nums , int start , int end){
        int prev = nums[start]; 
        int prev2 = 0;

        for(int idx = start+1 ; idx <= end ; idx++){
            int pick = prev2 +nums[idx];
            int notpick = prev;

            prev2 = prev;
            prev = Math.max(pick,notpick);
        }
        return prev ;
    }
}
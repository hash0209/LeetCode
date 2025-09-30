class Solution {
    public int rob(int[] nums) {

       
        int prev2 =0 ; int prev = nums[0];
       

        for(int idx =1; idx < nums.length ; idx++){
            int rob = prev2+nums[idx];
            int notrob = prev;
            prev2=prev;
            prev=Math.max(rob,notrob);
        }

        return prev;
        
    }


}
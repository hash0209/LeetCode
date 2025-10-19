class Solution {
    public int minMoves(int[] nums) {

        int mini = Integer.MAX_VALUE;
      

        for(int i =0; i < nums.length ; i++){
            mini =Math.min(nums[i],mini);
            
           
        }
         int moves =0;

         for(int i =0; i< nums.length ; i++){
            moves+= nums[i]-mini;

         }
         return  moves;

        
    }
}
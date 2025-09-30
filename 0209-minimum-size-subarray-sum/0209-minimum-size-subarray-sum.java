class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
       int l =0; int r = 0;

       int minlen = Integer.MAX_VALUE;

       int sum = 0;

       while(r < nums.length){
          sum+= nums[r];

          while(sum >= target){
               minlen = Math.min((r-l+1),minlen);
               sum=sum-nums[l];
               l++;
          }
          r++;
          
       }
       return minlen == Integer.MAX_VALUE ? 0 : minlen;
}
}
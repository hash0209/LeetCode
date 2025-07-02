class Solution {
    public int jump(int[] nums) {
      int jumps =0;
      int l =0;
      int r= 0;

      while(r < nums.length-1){
           int temp =l;
           int farthest=0;
           while(temp <= r){
               farthest = Math.max(farthest , temp+nums[temp]);
               temp++;
           }
           l =r+1;
           r =farthest;
           jumps++;
      }
      return jumps;
    }
}
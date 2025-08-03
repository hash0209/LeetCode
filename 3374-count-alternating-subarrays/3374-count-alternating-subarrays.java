class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        
        int l =0;
        int r =0;

        long count = 0L;

        while(r < nums.length){

            if(r > 0 &&  nums[r] == nums[r-1] ){
                l =r;
            }

            count+= r-l+1;
            r++;

        }

        return count;




    }
}
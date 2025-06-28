class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        return find(nums , k)-find(nums , k-1);
        
    }

    public int find(int[] nums , int k){
        int l =0; 
        int r=0;

        int count =0; 
        int odds =0;

        while(r< nums.length){
             if(nums[r]%2==1){
                odds ++;
             }

             while(odds > k){
                if(nums[l]%2==1){
                    odds--;
                }
                l++;
             }
             count = count+(r-l+1);
             r++;


        }
        return count;
    }



}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l =0; 

        int r =0; 

        int count =0;
        int maxlength = 0;


        while(r < nums.length){

            if(nums[r] == 0){
                if(count == k){
                    if(nums[l] == 0){
                        l++;
                        
                    }
                    else{
                        while(nums[l]!=0){
                            l++;
                        }
                        l++;
                    }
                }
                else{
                    count++;
                }
            }


            maxlength = Math.max(maxlength, r-l+1);
            r++;




            
        }

        return maxlength;
    }
}
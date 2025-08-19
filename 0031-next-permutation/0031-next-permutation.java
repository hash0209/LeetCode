class Solution {
    public void nextPermutation(int[] nums) {

       
        int n = nums.length;
        int idx =n-2;

        while(idx >=0 && nums[idx] >= nums[idx+1]){
            idx --;
        }


        if(idx!=-1){

            int idx2 = -1;
            int nums2 = Integer.MAX_VALUE;
           
            for(int i = idx+1; i < n ; i++){
                if(nums[i] > nums[idx] && nums[i]<= nums2){
                     idx2 = i;
                     nums2 =nums[i];
                }
            }

            int temp = nums[idx];
            nums[idx]=nums[idx2];
            nums[idx2] =temp;


        }

        int l = idx+1;
        int r =nums.length-1;

        while(l < r){
            int temp = nums[l];
            nums[l] =nums[r];
            nums[r] =temp;
            l++;
            r--;
        }

        
    }
}
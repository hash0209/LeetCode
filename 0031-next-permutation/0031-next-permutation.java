class Solution {
    public void nextPermutation(int[] nums) {

       
        int n = nums.length;
        int idx =-1;
        for(int i =n-2; i>= 0; i-- ){
            if(nums[i] < nums[i+1]){
                idx =i;
                break;
            }
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

        int l =idx+1;
        int r =n-1;

        while(l < r){
            int temp = nums[l];
            nums[l] =nums[r];
            nums[r] =temp;
            l++;
            r--;
        }

        
    }
}
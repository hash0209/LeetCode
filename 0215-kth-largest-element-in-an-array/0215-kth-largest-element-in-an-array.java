class Solution {
    public int findKthLargest(int[] nums, int k) {

                return sort(0,nums.length-1,nums,k-1);

        
    }



    public int sort(int start , int end , int[] nums , int k ){
        if(start==end){
            return nums[start];
        }
           int pIndex = start ;
           int pivot = nums[end];


           for(int i = start;  i < end ; i++){
                    if(nums[i] > pivot){
                        swap(i , pIndex,nums);
                        pIndex++;
                    }
           }
           swap(pIndex,end,nums);

           if(pIndex == k){
            return nums[pIndex];
           }

           if(pIndex > k){
            return sort(start , pIndex-1,nums,k);
           }
           else{
            return sort(pIndex+1,end,nums,k);
           }
    }

    public void swap(int left , int right , int[] nums){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] =temp;
    }
}
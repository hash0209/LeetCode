class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;

        int low =0; int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;
          

            if(nums[mid] < target){
                low=mid+1;
            }
            else{
              if(nums[mid] == target){
                first = mid;
               
            }
             high = mid-1;
            }


        }

        low=0; high =nums.length-1;
        int second =-1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] >  target){
                high = mid-1;
            }
            else{
              if(nums[mid] == target){
                second = mid;
               
            }
             low = mid+1;
            }


        }

        int[] res =new int[]{first,second};
        return res;

        
    }
}
class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length ==1){
            return 0;
        }

        int low =0; 
        int high = nums.length-1;

        while(low <= high){
           
            int mid =(low+high)/2;

            int before = mid-1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE;

            int after = mid+1 < nums.length ? nums[mid+1] : Integer.MIN_VALUE;

            if(before < nums[mid] && nums[mid] >  after){
                return mid;
            }
            else if (nums[mid] < after){
                low =mid+1;

            }
            else{
                high = mid-1;
            }
        }

        return -1;
        
    }
}
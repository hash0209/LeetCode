class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length-1;

        if(n ==0){
            return n;
        }

        int low = 0;
        int high = n;

        if(nums[low] > nums[low+1]){
             return low;
        }

        if(nums[high]> nums[high-1]){
            return high;
        }

        low=low+1;
        high=high-1;

        



        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }

            if(nums[mid] >= nums[mid-1] && nums[mid] <= nums[mid+1]){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
        
    }
}
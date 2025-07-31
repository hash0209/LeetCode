class Solution {
    public int lengthOfLIS(int[] nums) {

        int currSize = 0;
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length ; i++){

            int idx = find(0,currSize-1,nums[i],ans);

            ans[idx] = nums[i];

            if(idx == currSize){

                currSize++;

            }
        }

        return currSize ;


        
    }

    public int find(int low , int high , int target , int[] ans){

        int lb = high+1;

        while(low <= high){
            int mid =(low+high)/2;

            if(ans[mid] >= target ){
                lb = mid;
                high =mid-1;
            }
            else{
                low = mid+1;

            }
        }
        return lb;
    }
}
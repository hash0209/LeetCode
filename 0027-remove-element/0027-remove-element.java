class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;
       

        while(i < nums.length && nums[i]!= val){
             i++;
        }

        for(int j = i+1 ; j < nums.length ; j++){
              if(nums[j] != val){
                 nums[i]=nums[j];
                 i++;
              }
        }
        return i ;
        
    }
}
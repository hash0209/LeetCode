class Solution {
    public boolean isUgly(int n) {
        

        if(n == 0){
            return false;
        }

        int[] nums = new int[]{2,3,5};

        for(int i =0; i < nums.length ; i++){
               while(n%nums[i] == 0){
                  n = n/nums[i];
               }
        }

        return (n==1) ? true : false;
    }
}
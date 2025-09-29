class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length-1;

        int pMax =Integer.MIN_VALUE;
        int prefix=1;

        int sMax=Integer.MIN_VALUE;
        int suffix=1;

        for(int i =0; i < nums.length;i++){
            if(nums[i] == 0){
                pMax = Math.max(pMax,0);
                prefix=1;
            }
            else{
                prefix =prefix * nums[i];
                pMax = Math.max(pMax,prefix);
            }

            if(nums[n-i] ==0){
                sMax = Math.max(sMax,0);
                suffix=1;
                
            }
            else{
                suffix=suffix*nums[n-i];
                sMax = Math.max(suffix,sMax);
            }


        }

        return Math.max(sMax,pMax);

        
    }
}
class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length-1;

        int maxArea = 0;

        int lmax = 0;
        int rmax= 0;

        while(l < r){

            if(height[l] <=  height[r]){
                if(height[l] > lmax){

                    lmax =height[l];
                    int width = r-l ;
                    maxArea =Math.max(maxArea, width * height[l]);
                }
                l++;
            }
            else{
                if(height[r] > rmax){
                    rmax = height[r];
                    int width = r-l;
                    maxArea = Math.max(maxArea , width * height[r]);
                }
                r--;
            }
           
        }

        return maxArea ;
        
    }
}
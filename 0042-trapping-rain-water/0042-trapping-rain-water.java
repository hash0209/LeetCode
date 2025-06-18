class Solution {
    public int trap(int[] height) {
       

       int lmax = 0;
       int rmax = 0;

       int l =0;
       int r = height.length-1;

       int total =0;

       while(l < r){
        if(height[l] <= height[r]){
            if(lmax > height[l]){
                total = total + lmax -height[l];

            }
            else{
                lmax =height[l];
            }
            l++;
        }
        else{
            if(rmax > height[r]){
                total = total + rmax -height[r];

            }
            else{
                rmax =height[r];
            }
            r--;
        }
       }


       return total;

    }
}
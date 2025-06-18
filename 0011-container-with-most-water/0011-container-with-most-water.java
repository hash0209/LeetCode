class Solution {
    public int maxArea(int[] height) {


        int maxTotal =0;
        

        int total = 0;

        int l=0;
        int r= height.length-1;

        int lmax =0;

        int rmax =0;


        while(l < r){
            

            if(height[l]<= height[r]){
                  if(height[l] > lmax){
                    total =height[l] * (r-l);
                    lmax = height[l];
                    maxTotal = Math.max(maxTotal,total);
                  }
                  else{
                    l++;
                  }
            }
            else{
                if(height[r] > rmax){
                    total =height[r] * (r-l);
                    rmax = height[r];
                    maxTotal = Math.max(maxTotal,total);
                  }
                  else{
                   r--;
                  }
            }
        }

        return maxTotal;
    }
}

class Solution {
    public int trap(int[] height) {

        HashMap<Integer, Integer> pMaxMap = new HashMap<>();
        HashMap<Integer, Integer> sMaxMap = new HashMap<>();

        int left = 0;
        int right = height.length - 1;

        int pMax = 0;
        int sMax = 0;

        while (left < height.length && right >= 0) {

            if(pMax > height[left]){
                pMaxMap.put(left ,pMax);
            }
            else{
                pMaxMap.put(left , 0);
            }
            
            if(sMax > height[right]){
                sMaxMap.put(right , sMax);
            }
            else{
                sMaxMap.put(right,0);
            }
            pMax = Math.max(pMax, height[left]);
            sMax = Math.max(sMax, height[right]);

            left++;
            right--;

        }

        int waterTrapped = 0;

        for (int i = 0; i < height.length; i++) {
            pMax = pMaxMap.get(i);
            sMax = sMaxMap.get(i);

          

            if (pMax != 0 && sMax != 0) {

                int minMax = Math.min(pMax, sMax);
               

                waterTrapped = waterTrapped + minMax - height[i];
               
            }
        }

        return waterTrapped;

    }
}
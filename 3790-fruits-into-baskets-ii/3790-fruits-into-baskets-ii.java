class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int unplaced =0;

        boolean[] placed = new boolean[fruits.length];


        for(int i = 0; i < fruits.length ; i++){

            boolean found = false;

            for(int j =0; j < baskets.length ; j++){
                if(baskets[j]>= fruits[i] && !placed[j]){
                     placed[j] = true;
                     found = true;
                     break;
                }
            }
            if(!found){
                unplaced++;
            }
        }
        return unplaced;



        

           
        
    }
}
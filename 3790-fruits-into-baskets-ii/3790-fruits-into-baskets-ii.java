class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] taken = new boolean[fruits.length];

        int count = 0;

        for(int i =0; i < fruits.length ; i++){

            boolean placed =false;
            for(int j =0; j < baskets.length ; j++){
                if(fruits[i] <= baskets[j] && !taken[j]){
                    taken[j] = true;
                    placed =true;
                    break;
                }
            }
            if(!placed){
                count++;
            }
        }

        return count ;
        
    }
}
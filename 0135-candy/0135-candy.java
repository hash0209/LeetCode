class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int sum = 1;
        int i = 1;
        while (i < n) {
            while (i < n && ratings[i] == ratings[i - 1]) {
                sum++;
                i++;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                sum += down;
                i++;
            }
            down++;
            
            if (down > peak) {
               
                sum += down - peak;
            }
        }
        return sum;

    }
}
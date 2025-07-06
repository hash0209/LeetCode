class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , Comparator.comparing((int[] a) -> a[0]));

        int count =0;

     int i =0; 

     while(i < points.length){
       // int start = points[i][0];
        int end = points[i][1];
        i++;

        while(i < points.length && points[i][0] <= end){
               //  start = Math.min(start,points[i][0]);
                 end = Math.min(end , points[i][1]);
                 i++;
        }
        count++;


     }

     return count;
    }
}
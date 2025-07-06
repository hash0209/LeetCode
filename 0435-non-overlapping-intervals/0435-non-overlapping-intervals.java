class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      // Comparator<int[]> comparator = Comparator.comparing(arr -> arr[0]) // Sort by the first column
       
        Arrays.sort(intervals ,Comparator.comparingInt((int[] a) -> a[1]));

      // Arrays.sort(intervals, comparator);

        int count = 0;
        
        int prevEnd = Integer.MIN_VALUE;;

        for(int i =0 ; i < intervals.length ; i++){
            if(intervals[i][0] >= prevEnd){
                count++;
                prevEnd = intervals[i][1];
            }
           
            
        }

        return intervals.length -count ; 



    }
}
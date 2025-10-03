class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] arr = new int[intervals.length];
        int[] dep = new int[intervals.length];

        for(int i =0; i < intervals.length ; i++){
             arr[i] = intervals[i][0];
             dep[i] = intervals[i][1];
        }

        Arrays.sort(arr);
        Arrays.sort(dep);


        int left =0;
        int right =0;

        int count =0;

        int max =0;

        while(left < intervals.length){

            if(arr[left] < dep[right]){
                count++;
                left++;
            }
            else{
                count--;
                right++;
            }

            max = Math.max(count,max);

        }
         

         return max;
        
        
    }
}
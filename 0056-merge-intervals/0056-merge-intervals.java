class Solution {
    public int[][] merge(int[][] intervals) {
        int start = intervals[0][0];
        int end = intervals[0][1]; 

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        int i =0;
        List<List<Integer>> ans = new ArrayList<>();


        while(i < intervals.length ){
                start = intervals[i][0];
                end= intervals[i][1];
                i++;
       
                while(i < intervals.length &&  isOverlapping(intervals[i][0] ,intervals[i][1],start , end)){
                    start = Math.min(start , intervals[i][0]);
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }

                ans.add(Arrays.asList(start,end));
                
               
        }

        int[][] arr = new int[ans.size()][2];

        for(int j =0; j < ans.size() ;j++){
            arr[j][0] = ans.get(j).get(0);
            arr[j][1] =ans.get(j).get(1);
        }

        return arr;


    }

    public boolean isOverlapping(int start , int end , int newStart , int newEnd){
        if(newStart > end || newEnd < start){
            return false;
        }
        return true;
    }
}
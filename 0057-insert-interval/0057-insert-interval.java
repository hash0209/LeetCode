class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<List<Integer>> ans = new ArrayList<>(); //(1,2)

       
 //first 

       int i =0;

       
    

        while(i < intervals.length &&  newInterval[0] > intervals[i][1] ){

             
             ans.add(Arrays.asList(intervals[i][0] ,intervals[i][1]));
             i++;
        }

        int start = newInterval[0];
        int end= newInterval[1];


        while(i < intervals.length && isOverlap(intervals[i][0] , intervals[i][1] , start , end  )){
                 start = Math.min(start , intervals[i][0]);
                 end = Math.max(end , intervals[i][1]);
                 i++;
            
        }

        ans.add(Arrays.asList(start,end));


        while(i < intervals.length && end < intervals[i][0] ){
             ans.add(Arrays.asList(intervals[i][0] ,intervals[i][1]));
             i++;
        }

        int[][] arr = new int[ans.size()][2];

        for(int j =0 ; j < ans.size(); j++){
            arr[j][0] = ans.get(j).get(0);
            arr[j][1] = ans.get(j).get(1);

        }

        return arr;

   
    }


    public boolean isOverlap(int start , int end  , int newStart , int newEnd){
        if(newEnd < start || newStart > end){
            return false;
        }

        
            return true;
        


    }
}
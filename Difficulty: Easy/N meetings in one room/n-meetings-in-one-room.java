class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
        



    public int maxMeetings(int start[], int end[]) {
        // add your code here
        
        ArrayList<Meetings> list = new ArrayList<>();
        
        int i =0;
        while(i < start.length){
            Meetings m = new Meetings(start[i],end[i]);
            list.add(m);
            i++;
        }
        list.sort(Comparator.comparing(Meetings::getEnd).thenComparing(Meetings::getStart));
        
        int count =0;
        int prevEnd = -1;
        
        for(Meetings m : list){
            if(m.getStart() > prevEnd ){
                count++;
                prevEnd=m.getEnd();
            }
        }
        
        return count ;
    }
}

class Meetings{
    private int start; 
    private int end ;
    
    public Meetings(int start , int end){
        this.start=start;
        this.end=end;
    }
    
    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}




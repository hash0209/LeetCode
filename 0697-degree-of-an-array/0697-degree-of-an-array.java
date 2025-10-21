class Solution {
    public int findShortestSubArray(int[] nums) {
        
            
            Map<Integer,Pair> map = new HashMap<>();

            int maxFreq = 0;
            int frequency =0;
            for(int i=0; i < nums.length ; i++){
                   if(map.containsKey(nums[i])){
                        Pair p =map.get(nums[i]);
                        map.put(nums[i] , new Pair(p.start,i,p.frequency+1));
                        frequency = p.frequency+1;
                   }
                   else{
                      map.put(nums[i], new Pair(i,i,1));
                      frequency =1;
                   }
                   maxFreq= Math.max(frequency,maxFreq);
                
            }

             
          

            int minlen = Integer.MAX_VALUE;

            for(Integer key :  map.keySet()){
                if(map.get(key).frequency==maxFreq){
               
                    Pair p = map.get(key);
                    minlen = Math.min(minlen,p.end-p.start+1);
                 }
            }
            return minlen;

            






    }



}

class Pair{
    public int start =-1;
    public int end =-1;
    int frequency =0;

    public Pair(int start , int end , int frequency){
              this.start =start;
              this.end=end;
              this.frequency = frequency;
    }


}
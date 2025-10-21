class Solution {
    public int findShortestSubArray(int[] nums) {
        
            Map<Integer,Integer> freq = new HashMap<>();
            Map<Integer,Pair> map = new HashMap<>();

            int maxFreq = 0;
            for(int i=0; i < nums.length ; i++){
                int frequency = freq.getOrDefault(nums[i],0)+1;
                freq.put(nums[i] , frequency);
                maxFreq =Math.max(maxFreq,frequency);
                if(map.containsKey(nums[i])){
                
                    map.put(nums[i],new Pair(map.get(nums[i]).start ,i));
                }
                else{
                    map.put(nums[i],new Pair(i,i));
                }
            }

             
            List<Integer> l = new ArrayList<>();

            for(Integer key :  map.keySet()){
                if(freq.get(key)==maxFreq){
               
                    l.add(key);
                 }
            }

            int minlen = Integer.MAX_VALUE;

            for(Integer x : l){
                Pair p = map.get(x);
                minlen = Math.min(minlen,p.end-p.start+1);
            }
            return minlen;






    }



}

class Pair{
    public int start =-1;
    public int end =-1;

    public Pair(int start , int end){
              this.start =start;
              this.end=end;
    }


}
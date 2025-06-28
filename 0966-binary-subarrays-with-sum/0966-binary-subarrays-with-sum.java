class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;
        int psum =0;

        for(int i =0; i < nums.length ; i++){
               
               psum= psum +nums[i];
               if(psum == goal ){
                count = count+1;
               }
               if(map.containsKey(psum-goal)){
                   count =count+ map.get(psum-goal);
               }

               int f =1;

               if(map.containsKey(psum)){
                    f = map.get(psum) +1 ;
               }
               map.put(psum,f);
        }

        return count;
    }
}
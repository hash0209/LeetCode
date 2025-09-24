class Solution {
    public int longestConsecutive(int[] nums) {

         Set<Integer> set = new HashSet<>();


        for(Integer i : nums){
            set.add(i);
        }

         

         

          int maxlen = 0;

          for(Integer i : set){
            if(!set.contains(i-1)){
                  int n = i;
                  int len =1;
                  while(set.contains(n+1)){
                    len++;
                    n =n+1;
                  }
                  maxlen = Math.max(maxlen , len);
            }
          }

          return maxlen;
        
    }
}
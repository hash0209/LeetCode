class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
       

        HashMap<String,Integer> freqMap = new HashMap<>();

        for(int i =0; i < nums.length ; i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        int n = target.length();

        for(int i =0; i < target.length() ; i++){
            String prefix = target.substring(0,i);
            String suffix = target.substring(i,n);

            int prefixCount = freqMap.getOrDefault(prefix,0);
            int suffixCount =freqMap.getOrDefault(suffix,0);

            if(prefixCount!=0 && suffixCount!=0){
                if(prefix.equals(suffix)){
                    count+=prefixCount*(prefixCount-1);
                }
                else{
                    count+= (prefixCount * suffixCount );
                }
            }
            

        }
        
        return count;
    }
}
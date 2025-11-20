class Solution {

    // 1. Create a frequency hashMap
    //2 . add nums with frequency to Map
    //3 . Create an arrayList of ArrayList
    //4. initialize with n empty ArrayList (bucket)
    //5. iterate over the keys in the map and add it to the respective frequency bucket
    //6. iterate over buckets in reverse and get k elements
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(Integer i : nums){
              int freq = freqMap.getOrDefault(i,0);
            
              freqMap.put(i,freq+1);
        }


        List<List<Integer>> buckets = new ArrayList<>();
        for(int i =0; i <= nums.length ; i++){
            buckets.add(new ArrayList<>());
        }

        for(Integer key : freqMap.keySet()){
              buckets.get(freqMap.get(key)).add(key);
        }

        int[] res = new int[k];
        int idx = k-1;


        for(int i =  buckets.size()-1; i >= 0 ; i--){

                 List<Integer> bucket = buckets.get(i);

                 for(Integer num : bucket){
                    if(idx < 0){
                        break;
                    }
                    res[idx] = num;
                    idx--;
                 }


        }
        return res;
        

        
    }
}
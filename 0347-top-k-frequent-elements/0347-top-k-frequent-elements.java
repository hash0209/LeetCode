class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freq = new HashMap<>(); 

        for(Integer i : nums){

               freq.putIfAbsent(i , 0);
               freq.put(i , freq.get(i)+1);
        }


        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i <= nums.length ; i++){
            list.add(new ArrayList<>());
        }

        
        for(Integer key : freq.keySet()){

            int f = freq.get(key);
            list.get(f).add(key);

        }



        int[] res = new int[k];

        int idx = k-1;
        for(int i = list.size()-1 ; i >= 0 ; i--){
            List<Integer> l = list.get(i);
             for(int j = 0;  j < l.size() ; j++){
                if(idx < 0){
                    break;
                }
                     res[idx] = l.get(j);
                     idx--;
             }
        }
        return res;
        
    }
}
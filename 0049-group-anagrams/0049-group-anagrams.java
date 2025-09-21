class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        

        for(int i =0 ; i < strs.length ; i++){
            
            
            

            int[] freq = new int[26];
            StringBuilder key = new StringBuilder();

            for(char c : strs[i].toCharArray() ){
                freq[c-'a']++;
                   
                  
            }

            for(int  j = 0; j < freq.length ; j++){
                key.append(freq[j] + "#");
                
            }

            String k = key.toString();

            map.putIfAbsent(k,new ArrayList<>());
            map.get(k).add(strs[i]);
           
            
             
        }



        List<List<String>> res = new ArrayList<>();

        for(List<String> l : map.values()){
               res.add(l);
        }

        return res;

        
    }
}
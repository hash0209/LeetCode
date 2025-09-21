class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        

        for(int i =0 ; i < strs.length ; i++){
            
            char[] s = strs[i].toCharArray();
            

            int[] ch = new int[26];
            StringBuilder key = new StringBuilder();

            for(int j =0; j < s.length ; j++){
                ch[s[j]-'a']++;
                   
                  
            }

            for(int  j = 0; j < ch.length ; j++){
                key.append(ch[j]);
                key.append("#");
            }

            String k = key.toString();

            map.putIfAbsent(k,new ArrayList<>());
            List<String> l = map.get(k);
            l.add(strs[i]);
            map.put(k,l);
            
             
        }



        List<List<String>> res = new ArrayList<>();

        for(List<String> l : map.values()){
               res.add(l);
        }

        return res;

        
    }
}
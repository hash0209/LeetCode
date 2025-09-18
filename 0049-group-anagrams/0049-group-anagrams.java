class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(int i =0 ; i < strs.length ; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s =new String(ch);

            map.putIfAbsent(s,new ArrayList<>());
            List<String> l = map.get(s);
            l.add(strs[i]);
            map.put(s,l);
        }



        List<List<String>> res = new ArrayList<>();

        for(List<String> l : map.values()){
               res.add(l);
        }

        return res;

        
    }
}
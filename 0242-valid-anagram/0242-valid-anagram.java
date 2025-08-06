class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0; i < s.length() ; i++){
            int frequency = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),frequency+1);
        }

        for(int i =0; i < t.length() ; i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
            int frequency = map.get(t.charAt(i));
            if(frequency == 1){
                map.remove(t.charAt(i));
            }
            else{
                map.put(t.charAt(i),frequency-1);
            }
        }

        return map.isEmpty();
    }
}
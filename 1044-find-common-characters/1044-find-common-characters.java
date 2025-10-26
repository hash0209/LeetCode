class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character,Integer> map =new HashMap<>();
        for(char c : words[0].toCharArray()){
            map.putIfAbsent(c,0);
            map.put(c , map.get(c)+1);
        }

        for(int i=1; i < words.length ; i++){

             Map<Character,Integer> temp =new HashMap<>();

            for(char c : words[i].toCharArray()){
                if(map.containsKey(c)){
                    if(map.get(c) ==1){
                        map.remove(c);
                    }
                    else{
                        map.put(c , map.get(c)-1);
                    }
                     temp.putIfAbsent(c,0);
                     temp.put(c,temp.get(c)+1);

                }
                      
                }
                map = temp;


            }
        
        List<String> list = new ArrayList<>();


        for(char key : map.keySet()){
                  
                  int val = map.get(key);

                  for(int i=0; i < val ;i++){
                    list.add(String.valueOf(key));
                  }


        }
        return list;


    }
}

    

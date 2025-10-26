class Solution {
    public List<String> commonChars(String[] words) {
         int[] common = new int[26];

         for(char c : words[0].toCharArray()){
            common[c-'a']++;
         }
        

        for(int i  =1; i < words.length ; i++){

            int[] temp = new int[26];

            for(char c : words[i].toCharArray()){
                temp[c-'a']++;

            }

            for(int j=0; j < 26; j++){
                common[j] = Math.min(temp[j],common[j]);
            }
        }


        List<String> list = new ArrayList<>();

        for(int i=0; i < common.length ;i++){


            for(int val =0; val < common[i];val++){

                char c = (char)(i+'a');
                list.add(String.valueOf(c));
                
            }
        }
        return list;





    }
}

    

class Solution {
    public int similarPairs(String[] words) {

        boolean[] exists;
        int count = 0;

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {

              

              if(isSimilar(words[i],words[j])){
                count++;
              }

                
            }
        }

        return count;

    }

    boolean isSimilar(String s1, String s2) {

        char[] ch = s1.toCharArray();
        for(int i =0; i < ch.length ; i++){
            if(s2.indexOf(ch[i]) == -1){
                return false;
            }
        }

        char[] ch2 = s2.toCharArray();
        for(int i =0; i < ch2.length ; i++){
            if(s1.indexOf(ch2[i]) == -1){
                return false;
            }
        }
        return  true;

    }
}
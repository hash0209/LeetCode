class Solution {
    public int similarPairs(String[] words) {

       int[] dp = new int[words.length];
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for(int j = 0 ; j < i ; j ++){
                  if(isSimilar(words[i],words[j])){
                    dp[i] = Math.max(dp[i] ,1+dp[j]);
                  }
            }

          

             

                
            }
        int sum = 0;

        for(Integer i : dp){
            sum+=i;
        }
        return sum ;

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
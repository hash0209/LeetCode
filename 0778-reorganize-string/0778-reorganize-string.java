class Solution {
    public String reorganizeString(String s) {
        int[] freq =new int[26];

        char[] ch =s.toCharArray();
        for(int i =0; i < ch.length;i++){
            freq[ch[i]-'a'] = freq[ch[i]-'a']+1;
        }

        int n = ch.length;


        char[] res = new char[ch.length];
        int idx =0;
        while(true){

            int maxf = 0;
            int maxChar = -1;

            for(int i =0; i < 26 ; i++){
                if(freq[i] > maxf){
                    maxf = freq[i];
                    maxChar = i;
                }
            }
            if(maxf > (n+1)/2){
                return  "";
            }

            if(maxChar == -1){
                break ;
            }

            while(freq[maxChar] > 0){
                if(idx >= n) {
                    idx = 1;
                }
                res[idx] =(char) (maxChar + 'a');
                freq[maxChar] = freq[maxChar] -1;
                idx =idx +2;
            }



        }

        return new String(res);

    }
}
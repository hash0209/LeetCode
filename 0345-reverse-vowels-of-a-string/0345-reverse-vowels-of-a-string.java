class Solution {
    public String reverseVowels(String s) {
        boolean[] l = new boolean[26];
        l['a'-'a'] = true;
        l['e'-'a'] = true;
         l['i'-'a'] = true;
          l['o'-'a'] = true;
           l['u'-'a'] = true;

        char[] ch = s.toCharArray();


           

        
        int left = 0;
        int right = ch.length-1;

        while(left < right){

           boolean isLeft = Character.isLetter(ch[left]);
           boolean isRight = Character.isLetter(ch[right]);

           if(isLeft && isRight){

           

            char tempLeft = Character.toLowerCase(ch[left]);
            char tempright =Character.toLowerCase(ch[right]);

            if(l[tempLeft-'a'] && l[tempright-'a']){
                  char temp = ch[left];
                  ch[left] = ch[right];
                  ch[right] = temp ;
                  left++;
                  right--;
            }
            else if(l[tempLeft-'a']){
                right--;
            }
            else if(l[tempright-'a']){
                left++;
            }
            else{
                left++;
                right--;
            }
           }
           else if(isRight){
            left ++;
           }
           else if(isLeft){
            right--;
           }
           else{
            left++;
            right--;
           }

            
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i < ch.length;i++){
            sb.append(ch[i]);
        }
        return sb.toString();

    }
}
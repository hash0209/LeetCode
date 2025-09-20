class Solution {
    public boolean isPalindrome(String s) {
        int l =0; int r = s.length()-1;

        while(l < r){
               boolean lIsDigit = Character.isDigit(s.charAt(l));
               boolean lIsLetter = Character.isLetter(s.charAt(l));

               boolean rIsDigit = Character.isDigit(s.charAt(r));
               boolean rIsLetter = Character.isLetter(s.charAt(r));


               if((lIsDigit && rIsDigit) && (s.charAt(l)==s.charAt(r))){
                   l++;
                   r--;
               }
               else if((lIsLetter && rIsLetter ) && ((Character.toLowerCase(s.charAt(l))==(Character.toLowerCase(s.charAt(r)))))){
                l++;
                r--;
               }
               
               else if(!lIsDigit && !lIsLetter){
                     l++;
               }
               else if(!rIsDigit && !rIsLetter){
                r--;
               }
               else{
                return false;
               }

        }
        return true;
    }
}
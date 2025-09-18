class Solution {
    public int longestValidParentheses(String s) {

        int open =0; int close =0;

        int len =0;

        for(int i =0; i < s.length() ;i++){

            if(s.charAt(i) == ')'){
                close++;
            }
            else{
                open++;
            }

            if(open == close){
               len = Math.max(len , close);
            }
            if(close > open){
                open =0;
                close= 0;
            }

        }

        open =0; close =0;
        int len2 = 0;

        for(int i = s.length()-1 ; i >= 0 ; i--){
              if(s.charAt(i) == ')'){
                close++;
            }
            else{
                open++;
            }

            if(open == close){
               len2 =  Math.max(len2 ,open);
            }
            if(open > close){
                open =0;
                close= 0;
            }
            

        }

       return  2*Math.max(len,len2);
        
    }
}
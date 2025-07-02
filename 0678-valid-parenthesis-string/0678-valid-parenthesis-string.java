class Solution {
    public boolean checkValidString(String s) {
        

      

        int idx=0;
        int count =0;
        int countAst =0;

       
        while(idx < s.length()){
            char i = s.charAt(idx);

            if(i == '('){
               count++;
            }
            else if( i == '*'){
                countAst++;
            }
            else{
                if(count!=0){
                    count--;
                }
                else if(countAst!=0){
                    countAst--;
                }
                else{
                    return false;
                }
            }
            idx++;
        }

        if(count==0){
            return true;
        }
        if(countAst < count){
            return false;
        }

         count =0;
         countAst =0;

        idx =s.length()-1;
        while(idx >=0){
            char i = s.charAt(idx);

            if(i == ')'){
                count++;
            }
            else if( i == '*'){
               countAst++;
            }
            else{
                if(count!=0){
                    count--;
                }
                else if(countAst!=0){
                    countAst--;
                }
                else{
                    return false;
                }
            }
            idx--;
        }
        return true;
    }
}
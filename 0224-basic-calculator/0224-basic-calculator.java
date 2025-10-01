class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int res =0;
        int sign = 1;
        int num =0;

        for(int i = 0; i < s.length();i++){
            
            char c =s.charAt(i);
            if(c == ' '){
                continue;
            } 
            if(c == '+'){
                res=res+(sign* num);
                sign =1;
                num=0;

            }
            else if(c== '-'){
                res=res+(sign*num);
                sign=-1;
                num=0;

            }
            else if(Character.isDigit(c)){
                 
                 num=(num*10)+c-'0';

            }
            else if(c =='('){
                st.push(res);
                st.push(sign);

                res=0;
                sign=1;
                num=0;
            }
            else if(c ==')'){
                res+=sign*num;
                
                res=res*st.pop();
                res=res+st.pop();
                num=0;

            }
           
        }
        return res+(sign*num);


        
    }
}
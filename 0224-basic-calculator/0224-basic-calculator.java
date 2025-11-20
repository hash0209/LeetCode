class Solution {
    public int calculate(String s) {

        int res =0; 
        int prevSign =1;
        int num=0;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i < s.length() ;i++){
             if(s.charAt(i)==' '){
                continue;
             }

             if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                num=num*prevSign;
                res=res+num;
                if(s.charAt(i)== '-'){
                    prevSign = -1;
                }
                else{
                    prevSign=1;
                }
                num=0;


             }

             if(s.charAt(i)=='('){
                st.push(res);
                st.push(prevSign);
                res=0;
                prevSign=1;

             }

             if(s.charAt(i)==')'){
                res+= num*prevSign;
                res=res*st.pop();
                res=res+st.pop();

                num=0;
             }

            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i)-'0';
                num=num*10+digit;
            }

        }

        res= res +(num*prevSign);
        return res;
        
    }
}
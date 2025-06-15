class Solution {
    public boolean isValid(String s) {
       char[] c =s.toCharArray();
       Stack<Character> st = new Stack<Character>();

       for(int i =0; i < c.length ;i++){
        if(c[i] == '(' || c[i] == '{'  || c[i] == '['){
            st.push(c[i]);
        }
        else{

            if(st.isEmpty()){
                return false;
            }

            char ch = st.pop();
            if(c[i] == ')' && ch!= '('){
                return false;
            }
            else if(c[i] == '}' && ch != '{'){
                return false;
            }
            else if(c[i] == ']' && ch!= '['){
                return false;
            }

                
        }


   
       }
       return st.isEmpty();
    }
}
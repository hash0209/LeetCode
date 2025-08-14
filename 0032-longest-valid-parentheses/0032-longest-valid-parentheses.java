class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        int maxlength = 0;
         st.push(-1);

       for(int i =0; i<s.length() ; i++){
             char c = s.charAt(i);

             if(c =='('){
                st.push(i);
             }
             else{
                if(!st.isEmpty()){
                    st.pop();
                }

                if(st.isEmpty()){
                    st.push(i);
                }
             }
             maxlength = Math.max(maxlength , i-st.peek());

       }
       return maxlength ;


        
    }
}
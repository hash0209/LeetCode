class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st= new Stack<>();
        st.push(-1);
        int maxlen = 0;

        for(int i= 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                 st.push(i);
            }else{
                if(!st.isEmpty()){
                      st.pop();

                }
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxlen = Math.max(i-st.peek(),maxlen);
                }
            }

        }

        return maxlen;
        
    }
}
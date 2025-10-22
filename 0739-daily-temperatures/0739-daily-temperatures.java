class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int idx = temperatures.length-1; idx >= 0 ; idx--){

            while(!st.isEmpty() && temperatures[idx]>=  temperatures[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                res[idx] = st.peek()-idx;
            }
            else{
                res[idx]=0;
            }

            st.push(idx);

        }
        return res;
        
    }
}
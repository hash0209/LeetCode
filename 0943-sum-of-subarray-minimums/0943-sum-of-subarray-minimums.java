class Solution {
    public int sumSubarrayMins(int[] arr) {
        

        Stack<Integer> st = new Stack<Integer>();

        int[] parr = new int[arr.length];


        int mod = 1000000007;


        for(int i = 0; i < arr.length;i++){
                while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    parr[i] =-1;
                }
                else{
                    parr[i]  = st.peek();
                }

                st.push(i);
        }




        st = new Stack<Integer>();

        int[] narr = new int[arr.length];


        for(int i = arr.length-1 ; i  >=0;i--){
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    narr[i] = arr.length;
                }
                else{
                    narr[i]  = st.peek();
                }

                st.push(i);
        }

        long ans = 0;


        for(int i=0; i < arr.length ;i++){


           
            

            long left = i-parr[i];

            long right = narr[i] - i;

            long contributions = (left * right * arr[i]);

            ans = (ans + contributions)%mod;
          

        }

        return (int)ans;


        


    }
}
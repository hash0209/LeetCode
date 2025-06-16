class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans =new int[nums.length];

        int idx = nums.length-1;
        
        Stack<Integer> st = new Stack<>();
        for(int i =nums.length-2;i >=0 ;i--){
           st.push(nums[i]);
        }


        for(int i = nums.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[idx] = st.peek();
            }
            else{
                ans[idx] =-1;
            }
            idx = idx -1;
            st.push(nums[i]);
        }

        return ans;
    }
}
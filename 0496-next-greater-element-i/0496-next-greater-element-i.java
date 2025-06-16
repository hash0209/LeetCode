class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        int idx =0;

        HashMap<Integer,Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int i =nums2.length-1; i >=0 ; i--){
               //  if(st.isEmpty()){
               //     map.put(nums2[i],-1);
               //  }
               //  else{
                  // if(st.peek() > nums2[i]){
                 //   map.put(nums2[i], st.peek());
                //   }
                 //  else{
                    Stack<Integer> st2 = new Stack<>();
                    while(!st.isEmpty() && st.peek() < nums2[i]){
                       st2.push(st.pop());
                    }

                    if(!st.isEmpty()){
                        map.put(nums2[i],st.peek());
                    }
                    else{
                        map.put(nums2[i],-1);
                    }

                    while(!st2.isEmpty()){
                        st.push(st2.pop());
                    }
                //   }
             //    }
                 st.push(nums2[i]);
        }

    for(int i = 0;i<nums1.length;i++)
    {
        ans[idx] = map.get(nums1[i]);
        idx++;
    }

    return ans;

}}
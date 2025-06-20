class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> s = new Stack<>();

        int[] nge  = new int[nums.length];
       


        for(int i = nums.length -1; i >=0;i --){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                     s.pop();  
            }
            if(!s.isEmpty()){
                nge[i]  =s.peek();
            }
            else{
                nge[i] = nums.length;
            }
            s.push(i);
        }



        s = new Stack<>();
        int[] pge = new int[nums.length];
        


          for(int i = 0; i < nums.length;i ++){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                     s.pop();  
            }
            if(!s.isEmpty()){
                pge[i]  =s.peek();
            }
            else{
                pge[i] = -1;
            }
            s.push(i);
        }

        s = new Stack<>();

        int[] nse  = new int[nums.length];
       


        for(int i = nums.length -1; i >=0;i --){
            while(!s.isEmpty() && nums[s.peek()] > nums[i]){
                     s.pop();  
            }
            if(!s.isEmpty()){
                nse[i]  =s.peek();
            }
            else{
                nse[i] = nums.length;
            }
            s.push(i);
        }


        s = new Stack<>();
        int[] pse = new int[nums.length];
        


          for(int i = 0; i < nums.length;i ++){
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]){
                     s.pop();  
            }
            if(!s.isEmpty()){
                pse[i]  =s.peek();
            }
            else{
                pse[i] = -1;
            }
            s.push(i);
        }

        long ans = 0;


        for(int i = 0; i < nums.length ;i ++){
            //clculate max times 


            int pg = pge[i];
            int ng = nge[i];


            int left = i- pge[i];
            int right =nge[i] - i;

            int maxtimes = (left * right)-1;


            //calculate min times 

            left = i - pse[i];
            right = nse[i] - i;

            int mintimes = (left * right) -1;

            ans += (long) (maxtimes - mintimes)*nums[i];
            
        }


        return  ans;








    }
}
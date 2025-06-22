class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {



        ArrayList<Integer> ans = new ArrayList<>();
        


        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(0);


       for(int i =1; i < k ; i++){
        while(!q.isEmpty() && nums[q.peek()]< nums[i]){
                    q.pop();
        }
        q.push(i);
       }
      
       ans.add(nums[q.peekLast()]);

        for(int i =k; i < nums.length ; i++ ){
             while(!q.isEmpty() && nums[q.peek()]< nums[i]){
                    q.pop();
        }
        q.push(i);

        if(q.peekLast() > i-k){
            ans.add(nums[q.peekLast()]);
        }
        else{
            q.pollLast();
          // System.out.println(el);
            ans.add(nums[q.peekLast()]);
        }



        }


        int[] arr = new int[ans.size()];
        int idx =0;

        for(Integer x : ans){
            arr[idx] = x;
            idx ++;
        }

        return arr;
    }
}
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        List<Integer> list =new ArrayList<>();
        list.add(0);

        int min = 1;
       
        int max = nums[0];
        int jumps =1;

        while(true){
            if(max >= nums.length-1){
                return jumps;
            }
            jumps++;

            int tempMax = Integer.MIN_VALUE;
            

            for(int idx = min ; idx <= max ; idx++){
                tempMax = Math.max(tempMax , idx+nums[idx]);
                  
            }

            min=max+1;
            max = tempMax;

            

            


        }

        
    }


}
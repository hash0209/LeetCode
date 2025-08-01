class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {


        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int maxf = 1;

        int maxidx = 0;

        int[] prevArr = new int[nums.length];

        Arrays.fill(prevArr,-1);

        for (int curr =0; curr < nums.length ; curr++){

            for(int prev =0; prev < curr ; prev++){
              

                if(nums[curr] % nums[prev] == 0){
                      
                    int len = dp[prev]+1;
                   

                    if(dp[curr] < len){
                        dp[curr] = len;
                        prevArr[curr] = prev ;
                       

                        if (dp[curr] > maxf) {
                            
                            maxf = dp[curr];
                            maxidx =curr;
                        }
                    }
                   
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();


        while(maxidx!=-1){
             ans.add(nums[maxidx]);
             maxidx = prevArr[maxidx];
           

        }

        return ans;




        
    }
}
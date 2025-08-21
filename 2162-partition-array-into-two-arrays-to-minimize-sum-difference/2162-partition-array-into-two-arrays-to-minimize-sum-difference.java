class Solution {
    public int minimumDifference(int[] nums) {
        int sum =0;
        for(int i =0; i < nums.length ; i++){
            sum+=nums[i];
        }

        int target = sum/2;

        int n = nums.length/2;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i =0; i < n ; i++){
            left[i] = nums[i];
        }
        for(int i =n; i < nums.length ; i++){
            right[i-n] =nums[i];
        }

        List<List<Integer>> lSum = new ArrayList<>();
         List<List<Integer>> rSum = new ArrayList<>();
        for(int i =0; i <= n ; i++){
           lSum.add(new ArrayList<>());
           rSum.add(new ArrayList<>());
        }
       
       

        generateSubsets(left.length-1 , left , 0,0 ,lSum);
        generateSubsets(right.length-1 , right , 0,0 ,rSum);

        int ans =Integer.MAX_VALUE;



        for(int k =0; k <=n ; k++){
            List<Integer> l1 = lSum.get(k);
            List<Integer> r1 = rSum.get(n-k);

            Collections.sort(l1);
            Collections.sort(r1);

            int l =0;
            int r = r1.size()-1;

            while(l < l1.size() && r >= 0 ){
                   int s1 = l1.get(l) +r1.get(r);
                   int s2 = sum - s1;
                   int diff = Math.abs(s1-s2);
                   if(diff == 0){
                    return 0;
                   }
                  
                   ans = Math.min(ans ,diff);
                  
                   if(s1 > target ){
                    r--;
                   }
                   else{
                    l++;
                   }
            }
        }
        return ans;


    }

    public  void generateSubsets(int idx , int[] nums , int count , int sum ,List<List<Integer>> list){

        if(idx == -1){
            list.get(count).add(sum); 
            return ;
        }

        generateSubsets(idx-1 , nums , count+1 ,sum +nums[idx],list );
        generateSubsets(idx-1  , nums , count , sum , list);
    }
}
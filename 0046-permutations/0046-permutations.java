class Solution {
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        int n =1;

        for(int i =1 ; i <= len; i++){
            n = n * i;
        }

        

        List<List<Integer>> res = new ArrayList<>();

        

        for(int i =0; i < n ; i++){
            nums = find(nums);
            res.add(buildList(nums));
        }    
        return res;    
    }

    public int[] find(int[] nums){

        int idx = -1;

        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx =i;
                break;
            }
        }


        if(idx!=-1){
            int idx2 =-1;
            int num2 = Integer.MAX_VALUE;
            for(int i = idx+1 ; i < nums.length ; i++){
                if(nums[i] > nums[idx] && nums[i] <= num2 ){
                    idx2 =i ;
                    num2 = nums[i];
                }
            }

            int temp = nums[idx2];
            nums[idx2] = nums[idx];
            nums[idx] =temp;

            
        }


        int l = idx+1;
        int r = nums.length-1;

        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
        return nums;


    }

    public List<Integer> buildList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < nums.length ; i++){
            list.add(nums[i]);
        }
        return list;

    }
}
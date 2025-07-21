class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
              return nums[0];
        }
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();


        
        


        for(int i =0; i < nums.length ; i++){
            if(i!=0){
               nums1.add(nums[i]); 
            }
            if(i != nums.length-1){
                nums2.add(nums[i]);
            }
        }


        return Math.max(robb(nums1),robb(nums2));
    }



    public int robb(List<Integer> nums ){


        int prev2 = 0;
        int prev = nums.get(0);


        for(int idx =1 ; idx < nums.size() ; idx++){
           

            
            int pick = nums.get(idx) + prev2;

            int notPick = prev;


            prev2 = prev;
            prev = Math.max(pick , notPick);



        }

        return prev;
        
    }
}
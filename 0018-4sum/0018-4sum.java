class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length-3 ; i++){
            if(i !=0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j =i+1 ; j < nums.length-2 ; j++){

                if(j!=i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = nums.length-1;

                while(k < l){

                    Long sum = (long)nums[i]+ (long)nums[j]+ (long)nums[k]+(long)nums[l];

                    if(sum == target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        while(k < nums.length && nums[k] == nums[k-1]){
                            k++;
                        }

                        l--;
                        while(l >= 0 && nums[l] == nums[l+1]){
                            l--;
                        }

                        
                    }
                    else if(sum > target){

                        l--;
                          
                    }
                    else{
                        k++;
                    }
                }
            }
        }

        return list;
        
    }
}
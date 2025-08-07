class Solution {
    public int numOfPairs(String[] nums, String target) {

        int tlen = target.length();

        int count = 0;

        for(int i = 0; i < nums.length;i++){

            for(int j = 0; j < nums.length; j++){

                if(i == j){
                    continue;
                }
                if(nums[i].length()+nums[j].length() == tlen){
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[i]);
                    sb.append(nums[j]);
                    if(sb.toString().equals(target)){
                        count++;
                    }

                }
            }


        }

        return count ;

        
    }
}
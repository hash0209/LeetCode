class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i =0; int j =0;
        int count =0;

        while(j < nums.length ){
            count++;
            nums[i] =nums[j];
            j++;

            while(j < nums.length && nums[j]==nums[j-1]){
                j++;
            }

           i++;

          



        }

       return count ;


    }
    }

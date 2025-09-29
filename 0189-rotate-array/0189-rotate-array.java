class Solution {
    public void rotate(int[] nums, int k) {

        int n =nums.length;

        

        if(k > n ){
            k = k%n;
        }
        if(k == 0){
            return ; 
        }

        k = n-k-1;

        reverse(0,k,nums);
        reverse(k+1,n-1,nums);
        reverse(0,n-1,nums);


        
    }

    public void reverse(int start , int end , int[] nums){
           while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
           }
    }
}
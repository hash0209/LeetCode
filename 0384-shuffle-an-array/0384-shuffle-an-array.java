class Solution {

    int[] original ;
    int[] dummy ;
    Random rand ;

    public Solution(int[] nums) {
        original = nums.clone();
        dummy = nums.clone();
        rand = new Random();

        
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {

        for(int i = dummy.length-1; i >0; i --){
             int j = rand.nextInt(i+1);
             int tmp =dummy[j];
             dummy[j] = dummy[i];
             dummy[i] =tmp;

        } 

        return dummy;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
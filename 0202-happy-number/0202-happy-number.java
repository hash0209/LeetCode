class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();


      

       while(n!=1){
        set.add(n);
    
        int sum =0 ;

        while(n !=0){
           int digit = n%10;
            sum+= Math.pow(digit,2);
            n=n/10;
        }

        if(set.contains(sum)){
            return false;
        }

        n = sum;
       




       }
       return true;

    }
}
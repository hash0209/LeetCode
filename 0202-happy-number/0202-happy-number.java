class Solution {
    public boolean isHappy(int n) {
        
        if(n ==1){
            return true;
        }

        int slow = n;
        int fast = n;

        while(true){
            
             
             slow = sumOfSquares(slow);
             fast = sumOfSquares(sumOfSquares(fast));
             if(slow ==1){
                return true;
             }
             if(slow == fast){
               break;
             }

        }
        return false;
    }

    public int sumOfSquares(int n ){
        int sum =0;

        while(n!=0){
            int digit = n%10;
            sum+= Math.pow(digit,2);
            n=n/10;
          
        }
        return sum;
          
    
    }
}
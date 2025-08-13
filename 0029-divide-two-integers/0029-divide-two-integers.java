class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        



     
    
        

        

        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        
       

        long div1 = Math.abs((long)dividend);
        long div2 = Math.abs((long)divisor);
        long res =0;

        while(div1 >= div2){
            long mulitple =1;
            long temp = div2;

            while(div1 >= temp*2){
                temp = temp*2;
                mulitple = mulitple * 2;
            }

            res+=  mulitple;
            div1 = div1-temp;


        }

       
        

        
        

        return (int) (res * sign);

    }
}
class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        



        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend * -1;
        }
        

        

        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        int q = 0;
       

        int div1 = Math.abs(dividend);
        int div2 = Math.abs(divisor);

        while (div1 - div2 >= 0) {

          // // int digit = (lastdigit+1)%10;
           // if (sign == 1) {
            //    if (q > Integer.MAX_VALUE - 1 || (q == Integer.MAX_VALUE - 1 && digit % 10 > 7)) {
            //        return Integer.MAX_VALUE;
             //   }
         //   } else {
          //      if (q > Integer.MAX_VALUE - 1 || (q == Integer.MAX_VALUE - 1 && digit % 10 > 8)) {
            //        return Integer.MIN_VALUE;
            //    }
           // }
            q++;
          //  lastdigit = q%10;
            div1 = div1 - div2;
        }

        return q * sign;

    }
}
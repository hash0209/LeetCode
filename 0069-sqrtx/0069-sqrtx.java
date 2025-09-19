class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x ==1){
            return x;
        }
       

        long ans = 0;

        long low = 0;
        long high = x /2;

        while (low <= high) {
            long mid = (low + high) / 2;

            long prod = mid * mid;
            if (prod == x) {
                return (int)mid;
            }
           
            if (prod < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return (int) ans;

    }
}
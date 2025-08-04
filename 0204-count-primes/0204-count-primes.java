class Solution {
    public int countPrimes(int n) {

      int count = 0;
      if(n == 0 || n==1){
        return count;
      }

      boolean[] isprime = new boolean[n+1];

      Arrays.fill(isprime , true);

      isprime[0] = false;
      isprime[1] = false;

      for(int i =2 ; i < n ; i++){
        if(isprime[i]){
            count++ ;

            int multiple = 2;
            int num = i *multiple;

            while(num < n ){
                
                isprime[num] = false;

                multiple++;
                num=i*multiple;
            }
        }
      }
      return count ;

    }
}
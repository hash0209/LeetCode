class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;           
        }

        Long orig = (long)(x);


        Long reverse =0L;

        while(orig!=0){

            Long digit = orig%10L;

            reverse = reverse *10 + digit;
            orig = orig/10L;

        }

        

        return reverse == x ;
        
    }
}
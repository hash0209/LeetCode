class Solution {
    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        Long reverse = 0L;

        Long x1 = (long) x;

        while (x1 != 0) {
            Long digit = x1 % 10;
            x1 = x1 / 10L;

            reverse = (reverse * 10L) + digit;

        }

        if (reverse == x) {
            return true;
        }
        return false;

    }
}
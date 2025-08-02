class Solution {
    public String longestPalindrome(String s) {

        int max = 0;
        int start = 0;

        

        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < s.length(); j++) {

              
             if (isPalindrome(i, j, s)) {

                   

                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        start = i;
                    }

                }
                
            }
        }

        return s.substring(start, start + max);
    }

    public boolean isPalindrome(int left, int right, String s) {

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
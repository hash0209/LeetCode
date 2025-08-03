class Solution {
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);

        StringBuilder sb = new StringBuilder(s);
     

        StringBuilder sb2 = sb.reverse();
           

        if(s.equals(sb2.toString())){
            return true;
        }

        return false;
        
    }
}
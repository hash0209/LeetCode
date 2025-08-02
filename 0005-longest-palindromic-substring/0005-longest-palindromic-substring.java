class Solution {
    public String longestPalindrome(String s) {

        int maxlength = 0;
        int start =0;
        int end = 0;


        

        for(int i =0 ; i < s.length(); i++){

            int len1 = expand(i-1,i+1,s);
            int len2 = expand(i,i+1,s);

            int len =Math.max(len1,len2);

            if(len > end-start+1){
                start = i -(len-1)/2;
                end = i+len /2;
            }



        }

        return s.substring(start , end+1);
    }


    public int expand(int left , int right , String s){

        int start =0;
        int end = 0;


        while(left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right)){
            start = left ;
            end = right;
            left -- ;
            right++;
        }
        return end-start+1 ;
    }
}
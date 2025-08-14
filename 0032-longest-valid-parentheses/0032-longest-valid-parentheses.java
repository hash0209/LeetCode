class Solution {
    public int longestValidParentheses(String s) {
        int leftCount = 0; int rightCount = 0;  int maxlen =0;

        for(int i =0 ; i <s.length() ;i++){
            char c = s.charAt(i);
            if(c=='('){
                leftCount++;

            }
            else{
                rightCount++;
            }

            if(leftCount == rightCount){
                maxlen =Math.max(maxlen,leftCount+rightCount);
            }
            if(rightCount > leftCount){
                leftCount =0;
                rightCount=0;
            }
        }

         leftCount = 0;  rightCount = 0; 
        for(int i =s.length()-1 ; i >=0 ;i--){
            char c = s.charAt(i);
            if(c=='('){
                leftCount++;

            }
            else{
                rightCount++;
            }

            if(leftCount == rightCount){
                maxlen =Math.max(maxlen,leftCount+rightCount);
            }
            if(leftCount > rightCount){
                leftCount =0;
                rightCount=0;
            }
        }

        return maxlen;



    }
}
class Solution {
    public int longestStrChain(String[] words) {

        int[] dp = new int[words.length];

        Arrays.sort(words ,(a,b) -> a.length() -b.length());

        Arrays.fill(dp, 1);

        int maxf =1;

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < i; j++) {

                if (isValid(words[i], words[j])) {

                    int length = dp[j] + 1;
                    if (dp[i] < length) {
                        dp[i] = length;
                        maxf = Math.max(maxf, length);
                    }

                }

            }
        }

        return maxf;

    }

    public Boolean isValid(String curr , String prev){
        if(curr.length() == prev.length()+1){
            
        

        int count =0;
        int left = 0;
        int right = 0;

        while(right < prev.length() && left < curr.length() && count <= 1){

            if(curr.charAt(left) == prev.charAt(right)){
                     left++;
                     right++;
            }
            else{
                count++;
                left++;
            }

        }
        return (count <= 1);


    }
    return false;
    }

}
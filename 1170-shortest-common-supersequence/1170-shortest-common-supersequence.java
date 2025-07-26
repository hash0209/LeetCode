class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 1; i <= str1.length(); i++){

            for(int j =1 ; j <= str2.length(); j++){

                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        int i = str1.length();
        int j = str2.length();

        StringBuilder lcs = new StringBuilder();



        while( i > 0 && j > 0){
           if(str1.charAt(i-1)==str2.charAt(j-1)){
                 lcs.append(str1.charAt(i-1));
                 i--;
                 j--;
           }
           else{
            if(dp[i][j-1] > dp[i-1][j]){
                j--;
            }
            else{
                i--;
            }
           }


        }



        String lc = lcs.reverse().toString();


        StringBuilder ans = new StringBuilder();

         i =0;  j = 0; int k =0;

        while( k < lc.length()){
            if(str1.charAt(i) ==  str2.charAt(j) && str2.charAt(j) == lc.charAt(k)){
                ans.append(str1.charAt(i));
                i++;
                j++;
                k++;
            }
            else {
                while(str1.charAt(i) != lc.charAt(k)){
                    ans.append(str1.charAt(i));
                    i++;
                }

                 while(str2.charAt(j) != lc.charAt(k)){
                    ans.append(str2.charAt(j));
                    j++;
                }
            }
        }


        while(i < str1.length()){
            ans.append(str1.charAt(i));
            i++;

        }

          while(j < str2.length()){
            ans.append(str2.charAt(j));
            j++;

        }


   return ans.toString();

        


    }
}
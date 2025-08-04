class Solution {
    public String countAndSay(int n) {

        String ans = "1";

        for(int i =2 ; i <= n ; i++){


            int l = 0;
            int r = 0;
            StringBuilder sb = new StringBuilder();

            while(r < ans.length()){
                    if(ans.charAt(l) != ans.charAt(r)){
                          sb.append(String.valueOf(r-l));
                          sb.append(ans.charAt(l));
                          l = r ; 
                    }
                    r++;

            }
            sb.append(String.valueOf(r-l));
            sb.append(ans.charAt(l));
            ans= sb.toString();



        }

        return ans;
        
    }
}
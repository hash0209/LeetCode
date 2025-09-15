class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i =1; i < strs.length; i++){
            String s = strs[i];
            StringBuilder temp = new StringBuilder();

            int l = Math.min(prefix.length(),s.length());
            for(int j =0; j < l ; j++){
                  if(prefix.charAt(j)!=s.charAt(j)){
                   break;
                  }
                     temp.append(prefix.charAt(j));
                  
            }

            prefix = temp.toString();
        }
        return prefix;
    }
}
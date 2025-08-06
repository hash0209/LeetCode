class Solution {
    public String licenseKeyFormatting(String s, int k) {

       int count = 0;

       StringBuilder sb = new StringBuilder();

       for(int i =s.length()-1; i >= 0;i--){
            char c = s.charAt(i);
            if(c =='-'){
                continue;
            }

            if(Character.isDigit(c)){
                sb.append(c);
            }
            else{
                sb.append(Character.toUpperCase(c));
            }
            count++;
            if(count  == k){
                sb.append("-");
                count =0;

            }
       }

       if(count ==0 && sb.length() > 0){
        sb.deleteCharAt(sb.length()-1);
       }


        return sb.reverse().toString();
    }
}
class Solution {
    public String licenseKeyFormatting(String s, int k) {

        int count = 0;
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =s.length()-1; i >=0 ; i--){
            if(s.charAt(i) == '-'){
                continue;
            }
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else{
                 sb.append(Character.toUpperCase(s.charAt(i)));   
            }

            
            count++;

            if(count == k){
                list.add(new StringBuilder(sb));
                sb=new StringBuilder();
                count =0;
            }

        }

        if(count !=0){
            list.add(sb);
        }

        StringBuilder sb2 = new StringBuilder();
        for(int i = list.size()-1; i >= 0 ; i--){
            if( i == 0){
                sb2.append(list.get(i).reverse());
            }
            else{
                sb2.append(list.get(i).reverse() + "-");
            }
        }

        return sb2.toString();


        
    }
}
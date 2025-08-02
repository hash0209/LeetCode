class Solution {
    public int reverse(int x) {

        String s = String.valueOf(x);
        
        int left =0 ;
        if(s.charAt(0) == '-'){
            left++;
        }


        int right = s.length()-1;

        char[] ch = s.toCharArray();

        while(left < right){
           Character temp = ch[left];
           ch[left] =ch[right];
           ch[right] = temp;

           left++;
           right--;



        }
        StringBuilder sb = new StringBuilder();

        

        for(Character c :ch){
            sb.append(c);
        }

        Long val = Long.valueOf(sb.toString());
        if(val >= Integer.MAX_VALUE || val <= Integer.MIN_VALUE){
            return 0;
        }

        return Integer.valueOf(sb.toString());
        
        
    }
}
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            return addStrings(num2,num1);
        }

        //num2 is smaller

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        int left = num1.length()-1;
        int right = num2.length()-1;

        StringBuilder sb =new StringBuilder();
        int carry =0;

        while(right >= 0){

            int sum = ch1[left]-'0' + ch2[right]-'0' + carry;
            if(sum >=10){
                sum =sum-10;
                carry=1;
            }
            else{
                carry=0;
            }
            sb.insert(0,sum);
            left--;
            right--;

        }

        while(left >= 0){
            int sum = ch1[left]-'0'  + carry;
            if(sum >=10){
                sum =sum-10;
                carry=1;
            }
            else{
                carry=0;
            }
            sb.insert(0,sum);
            left--;

        }

        if(carry > 0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
class Solution {
    public boolean isHappy(int n) {

        int slow = sum(n);
        int fast = sum(sum(n));

        while(slow!=fast){
            if(slow ==1 || fast ==1){
                return true;
            }

            slow = sum(slow);
            fast = sum(sum(fast));
           

        }

        return (slow ==1)? true : false;
        
    }

    public int sum(int num){

        int sum =0;

        while(num!=0){
            int digit = num%10;
            int sq = digit * digit;
            sum=sum+sq;
            num=num/10;

        }
        return sum;
    }
}
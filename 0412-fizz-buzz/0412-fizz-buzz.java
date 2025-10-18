class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for(int i =0; i < n ; i++){
            list.add("");

        }

        for(int i =0; i < n ; i++){
            if(!list.get(i).isEmpty()){
                continue;
            }
             int num =i+1;
             int factor =1;

             while(num <= n){
                if(num % 3== 0 && num%5 == 0){
                    list.set(num-1,"FizzBuzz");

                }
                else if(num%3 == 0){
                     list.set(num-1,"Fizz");
             }
             else if(num%5==0){
                  list.set(num-1,"Buzz");
             }
             else{
                 list.set(num-1,String.valueOf(num));
             }

             factor++;
            num=num*factor;
             
             

             

        }
        }
        return list;


        
    }
}
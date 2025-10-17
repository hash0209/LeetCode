class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        

        if(n == 0){
            return 1;
        }
        if(n ==1 ){
            return 10;
        }

        int count = 1;

        for(int i = 1 ; i <= n ; i++){
            count+= find(i , 0 , new boolean[10]);
           
        }

        return count;


        
    }

    public int find (int digits , int taken , boolean[] visit){
          if(digits == taken){
            return 1;
          }

          int count= 0;


          for(int i =0; i <= 9 ; i++){
              if(taken==0 && i == 0){
                continue;
              }
              if(!visit[i]){
               visit[i] =true;
              
               taken++;
             
               count += find(digits , taken , visit);
               taken--;
               visit[i]=false;
              }
          }

          return count;
    }
}
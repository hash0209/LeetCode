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
            count+= find(i , new ArrayList<>() , new boolean[10]);
           
        }

        return count;


        
    }

    public int find (int digits , List<Integer> ds , boolean[] visit){
          if(digits == ds.size()){
            return 1;
          }

          int count= 0;


          for(int i =0; i <= 9 ; i++){
              if(ds.isEmpty() && i == 0){
                continue;
              }
              if(!visit[i]){
               visit[i] =true;
              
              ds.add(i);
             
               count += find(digits , ds , visit);
               ds.remove(ds.size()-1);
               visit[i]=false;
              }
          }

          return count;
    }
}
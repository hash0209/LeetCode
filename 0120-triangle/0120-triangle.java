class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        for(List<Integer> list : triangle ){
           
           dp.add(new ArrayList<>(list));
           
        }

     


      


        for(int row = 1 ; row < triangle.size() ; row ++){
            for (int idx = 0; idx < triangle.get(row).size();idx ++){

                int left = Integer.MAX_VALUE;


                if(idx  < triangle.get(row-1).size()){


                 left = dp.get(row-1).get(idx);
                }

                int right = Integer.MAX_VALUE;

                if(idx-1 >= 0){

                 right = dp.get(row-1).get(idx-1);
                }

                int ans = Math.min(left , right) +  triangle.get(row).get(idx);

                 dp.get(row).set(idx , ans);
                
            }
        }





        
       

       

       int ans = Integer.MAX_VALUE;

       for (int idx =0 ; idx < dp.get(dp.size()-1).size(); idx++){
                ans = Math.min(ans , dp.get(dp.size()-1).get(idx) );
       }

       return ans ;
    }



    public int find(List<List<Integer>> t , int row , int idx ,   List<List<Integer>> dp){

        if(idx >=  t.get(row).size()){
            return  Integer.MAX_VALUE;
        }

        if(row  ==  t.size() -1 ){
            return t.get(row).get(idx);
        }


        if(dp.get(row).get(idx)!=Integer.MAX_VALUE){
            return dp.get(row).get(idx);
        }

       



        
       int left = find(t , row+1 , idx , dp);
        


        
        int right = find(t, row+1 , idx+1 , dp) ;

        int ans = Math.min(left , right) +  t.get(row).get(idx);

        dp.get(row).set(idx , ans);

        

        return ans ;

    }
}
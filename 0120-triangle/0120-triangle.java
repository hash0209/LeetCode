class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

     List<Integer> dp = new ArrayList<>();

     dp.add(triangle.get(0).get(0));

       

     


      


        for(int row = 1 ; row < triangle.size() ; row ++){

            List<Integer> temp = new ArrayList<>(triangle.get(row));
            for (int idx = 0; idx < triangle.get(row).size();idx ++){

                int left = Integer.MAX_VALUE;


                if(idx  < triangle.get(row-1).size()){


                 left = dp.get(idx);
                }

                int right = Integer.MAX_VALUE;

                if(idx-1 >= 0){

                 right = dp.get(idx-1);
                }

                int ans = Math.min(left , right) +  triangle.get(row).get(idx);

                 temp.set(idx , ans);
                
            }

            dp = temp ; 
        }





        
       

       

       int ans = Integer.MAX_VALUE;

       for (int idx =0 ; idx < dp.size(); idx++){
                ans = Math.min(ans , dp.get(idx) );
       }

       return ans ;
    }




}
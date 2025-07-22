class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

     List<Integer> dp = new ArrayList<>();

     dp.add(triangle.get(0).get(0));

       

     


      


        for(int row = 1 ; row < triangle.size() ; row ++){

            List<Integer> temp = new ArrayList<>(triangle.get(row));
            List<Integer> rows = triangle.get(row);
            for (int idx = 0; idx < rows.size();idx ++){


               int left = (idx  < triangle.get(row-1).size()) ?  dp.get(idx) :  Integer.MAX_VALUE;

               int right = (idx-1 >= 0) ?  dp.get(idx-1) :  Integer.MAX_VALUE;

               int ans = Math.min(left , right) + rows.get(idx);

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
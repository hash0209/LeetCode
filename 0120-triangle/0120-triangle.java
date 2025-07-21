class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        for(List<Integer> list : triangle ){
           
           dp.add(new ArrayList<>(list));
           
        }

        for(List<Integer> list : dp){

            for(int i = 0; i < list.size() ; i++){
                list.set(i , Integer.MAX_VALUE);
            }
        }
       

       

        return  find(triangle , 0, 0 , dp);
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
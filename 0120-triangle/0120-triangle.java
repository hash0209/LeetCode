class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return  find(triangle , 0, 0);
    }



    public int find(List<List<Integer>> t , int row , int idx){

       

        if(row  ==  t.size() -1 ){
            return t.get(row).get(idx);
        }

       



        
       int left = find(t , row+1 , idx);
        


        
        int right = find(t, row+1 , idx+1) ;

        

        return Math.min(left , right) +  t.get(row).get(idx) ;

    }
}
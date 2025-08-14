class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList();

        for(List<Integer> t : triangle){
            dp.add(new ArrayList(t));
        }

        for(int row = triangle.size() -2 ; row >= 0; row --){

            for(int idx =0; idx < triangle.get(row).size() ; idx ++){

                int one = dp.get(row+1).get(idx);
                int two = dp.get(row+1).get(idx+1);

                dp.get(row).set(idx , Math.min(one,two) + triangle.get(row).get(idx));
            }

        }

       return  dp.get(0).get(0);
        
    }
}
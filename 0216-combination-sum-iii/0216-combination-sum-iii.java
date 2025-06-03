class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k==1 ){
           if(n >=1 && n <= 9){
            List<Integer> l = new ArrayList<>();
            l.add(n);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(l);
            return ans;
           }
           else{
            return  new ArrayList<>(); 
           }
        }

        return find(9 , k , n , new ArrayList<Integer>());
        
    }



    public List<List<Integer>> find(int n, int k , int t , List<Integer> ds){

        List<List<Integer>> res = new ArrayList<>();

        if(k == 0){
            if( t==0){
                 res.add(new ArrayList<>(ds));
            }
           return res;
        }

        if( n == 0){
             return res;
        }



       if(t >= n){
        ds.add(n);
        res.addAll(find(n-1 , k-1 , t-n ,ds ));
        ds.remove(ds.size()-1);
       }

        res.addAll(find(n-1,k , t,ds));

        return res;

        
    }



}
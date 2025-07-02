class Solution {
    
    class Test {
    private double k ;
    private int idx ;
    
    public Test(){
        
    }
    
    public Test(double k , int idx){
        this.k = k;
        this.idx =idx;
    }
    
    public double getK(){
        return k;
    }
    
     public int getIdx(){
        return idx;
    }
    
    
}
    
    
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        ArrayList<Test> arr = new ArrayList<>();
        
        double ans = 0.0;
        
        int idx =0;
        
        while(idx < values.length){
            double k = (double) values[idx]/(double) weights[idx];
            Test t = new Test(k,idx);
            arr.add(t);
            idx++;
        }
        
        arr.sort(Comparator.comparing(Test::getK).reversed());
        
       for(Test t : arr){
           if(W == 0){
               break;
           }
           int index = t.getIdx();
           if(W >= weights[index]){
               ans += (double) values[index];
               W = W-weights[index];
           }
           else{
               ans+= ((double) values[index] /(double) weights[index])*W;
               break;
           }
         
       }
       
       
       return ans;
        
        
        
        
        
    }
    
}


/*class Test {
    private double k ;
    private int idx ;
    
    public Test(){
        
    }
    
    public Test(double k , int idx){
        this.k = k;
        this.idx =idx;
    }
    
    public double getK(){
        return k;
    }
    
    
}*/
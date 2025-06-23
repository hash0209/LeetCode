class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}






class StockSpanner {
    int idx =0;

   // Stack<Integer> s ;
   // Map<Integer , Integer> map  ;

    Stack<Pair<Integer,Integer>> s ;

    public StockSpanner() {

        
        
        s =new Stack<>();
       // map = new HashMap<>();
    }
    
    public int next(int price) {
          int span = 1;
        
        
            while(!s.isEmpty() && s.peek().second <= price){
                   s.pop();
            }

            if(s.isEmpty()){
                 span = idx+1;
            }
            else{
                span = idx - s.peek().first;
            }

           
        
       // map.put(idx , price);
        s.push(new Pair(idx , price));
        idx++;

        return span;



    }
}



/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {
    int idx =0;

    Stack<Integer> s ;
    Map<Integer , Integer> map  ;

    public StockSpanner() {

        
        
        s =new Stack<Integer>();
        map = new HashMap<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        
            while(!s.isEmpty() && map.get(s.peek()) <= price){
                   s.pop();
            }

            if(s.isEmpty()){
                 span = idx+1;
            }
            else{
                span = idx - s.peek();
            }

           
        
        map.put(idx , price);
        s.push(idx);
        idx++;

        return span;



    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class MinStack {

      Stack<Pair<Integer,Integer>> st ;
      int min = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int currentMin = st.isEmpty() ? val : Math.min(val, st.peek().getValue());
        Pair<Integer,Integer> p = new Pair<>(val, currentMin);
        st.push(p);
    }
    
    public void pop() {
        st.pop();
      
    }
    
    public int top() {
        return st.peek().getKey();
    }
    
    public int getMin() {
        return st.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
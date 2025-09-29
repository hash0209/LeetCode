class MinStack {

    Stack<Pair> st ;
    int currentMin = Integer.MAX_VALUE;

    public MinStack() {

        st=new Stack<>();

        
    }
    
    public void push(int val) {
          currentMin= st.isEmpty() ? val : Math.min(currentMin,val);
          st.push(new Pair(val,currentMin));
    }
    
    public void pop() {
       int min = st.pop().value;
       currentMin = st.isEmpty() ? Integer.MAX_VALUE : st.peek().value;
    }
    
    public int top() {
       return st.peek().key;
    }
    
    public int getMin() {
       return  st.peek().value;
    }
}

class Pair{
    public int key;
    public int value;

    public Pair(int key , int value){
        this.key=key;
        this.value=value;

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
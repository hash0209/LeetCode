class MinStack {

    Stack<Pair> st ;
  

    public MinStack() {

        st=new Stack<>();

        
    }
    
    public void push(int val) {
         int min= st.isEmpty() ? val : Math.min(val,st.peek().currentMin);
         st.push(new Pair(val,min));
    }
    
    public void pop() {
          st.pop();
      
    }
    
    public int top() {
       return st.peek().val;
    }
    
    public int getMin() {
       return  st.peek().currentMin;
    }
}

class Pair{
    public int val;
    public int currentMin;

    public Pair(int val , int currentMin){
        this.val=val;
        this.currentMin=currentMin;

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
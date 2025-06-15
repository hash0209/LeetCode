class MyQueue {

    Stack<Integer> s ;
    Stack<Integer> s2;

    public MyQueue() {
        s = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s.isEmpty()){
                s2.push(s.pop());
            }
           
        }
         return s2.pop();
        
    }
    
    public int peek() {
         if(s2.isEmpty()){
            while(!s.isEmpty()){
                s2.push(s.pop());
            }
           
        }
         return s2.peek();
    }
    
    public boolean empty() {
        return s.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
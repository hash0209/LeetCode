class MyQueue {

    Stack<Integer> s ;

    public MyQueue() {
        
      s = new Stack<>();
   
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();

        while(!s.isEmpty()){
            temp.push(s.pop());
        }

        s.push(x);

        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() {
        return s.peek();
    }
    
    public boolean empty() {
        return s.isEmpty();
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
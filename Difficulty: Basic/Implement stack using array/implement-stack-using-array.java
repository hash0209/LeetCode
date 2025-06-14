class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }
    
    int idx =-1;

    public void push(int x) {
        idx =idx+1;
        arr[idx] = x;
        // Your Code
    }

    public int pop() {
        // Your Code
        if(idx == -1){
            return -1;
        }
        
        return arr[idx--];
       // idx = idx-1;
       // return el;
        
        
    }
}
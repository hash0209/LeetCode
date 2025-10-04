class MedianFinder {
    PriorityQueue<Integer> lower ;
    PriorityQueue<Integer> higher;

    public MedianFinder() {

        lower = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        higher = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {

        lower.add(num);

        if(!lower.isEmpty() && !higher.isEmpty() && lower.peek() > higher.peek()){
            higher.add(lower.poll());
        }

        if(higher.size() > lower.size()){
            lower.add(higher.poll());
        }
        else if(lower.size()-higher.size() > 1){
             higher.add(lower.poll());
        }
        
    }
    
    public double findMedian() {
        if(higher.size() == lower.size()){
            return(higher.peek() +lower.peek())/2.0;
        }
        else{
            return (double) lower.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
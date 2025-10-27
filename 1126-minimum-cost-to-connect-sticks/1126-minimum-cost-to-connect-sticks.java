class Solution {
    public int connectSticks(int[] sticks) {

        if(sticks.length==1){
            return 0;

        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i =0; i < sticks.length ; i++){
              minHeap.add(sticks[i]);
        }


       int cost =0;

        while(minHeap.size() >1){
             int sum = minHeap.poll()+minHeap.poll();
             minHeap.add(sum);
             cost+=sum;
        }
        return cost ;



   
        
    }
}
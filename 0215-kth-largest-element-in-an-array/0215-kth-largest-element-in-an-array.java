class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(Integer i: nums){
            maxHeap.add(i);
        }

        int ans = 0;

        while(k!=1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
        
        
    }
}
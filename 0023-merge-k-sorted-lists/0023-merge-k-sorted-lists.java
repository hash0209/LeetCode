/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length ==0){
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i = 0; i < lists.length ; i++){
            if(lists[i]!=null){
            minHeap.offer(lists[i]);
            }
        }


        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            System.out.println(smallest.val);
            dummy.next = smallest;
            dummy = dummy.next ;
            if(smallest.next!=null){
                minHeap.offer(smallest.next);
            }

        }

        return head.next;
            }
}
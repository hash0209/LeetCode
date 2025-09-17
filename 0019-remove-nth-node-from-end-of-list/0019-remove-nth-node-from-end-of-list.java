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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy;
        ListNode slow = dummy;

        dummy.next = head;

        for(int i =1 ; i <= n+1 ; i++){
            fast = fast.next;
        }


        while(fast!=null){
            fast = fast.next;
            slow=slow.next;
        }

        if(slow == dummy){
            return head.next;
        }

        slow.next = slow.next.next;
        return head;



        
    }
}
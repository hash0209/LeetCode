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

        int len = 0 ;
        ListNode temp = head;

        while(temp!=null){
            len++;
            temp = temp.next;

        }

         n = len-n;
        if(n == 0){
            return head.next;
        }

        temp = head;
        int count =0;
        while(temp!=null){
            count++;
            if(count==n){
                temp.next = temp.next.next;
                break;

            }
            temp = temp.next;
        }

        return head;
    }
}
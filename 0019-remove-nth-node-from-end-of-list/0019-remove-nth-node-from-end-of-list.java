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

        
        ListNode slow = head;

        int length = 0;

        while(slow!=null){
            slow =slow.next ;
            length++;
        }

        n = length - n;

        if(n == 0){
            return head.next;
        }


        ListNode temp = head;

        int count = 0;

        while(temp!=null){
            count++;

            if(count == n){
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next ;
           
        }


        return head;

       

        



       

        
    }
}
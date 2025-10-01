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
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;

        }

        ListNode fast =head;
        ListNode slow =head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode head2 = reverse(temp,null);

        while(head2!=null){
            
            if(head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }

        return true;
        
    }

    public ListNode reverse(ListNode curr , ListNode prev){
        if(curr == null){
            return prev;
        }

        ListNode temp = curr.next;
        curr.next=prev;
        return reverse(temp,curr);
    }
}
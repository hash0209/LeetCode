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
    public ListNode swapPairs(ListNode head) {

        if(head ==null  || head.next == null){
            return head;
        }

        int count = 1;

        ListNode temp = head;
        ListNode oldhead = head;
        ListNode prev = new ListNode(-1);
        ListNode ans = prev;

        while(temp!=null){
            if(count == 1){
                oldhead= temp;
            }
             ListNode tempNext = temp.next ;

            if(count == 2){
                 
                 
                  temp.next = null ;

                  ListNode newhead = reverse(oldhead , null);
                  prev.next = newhead;
                  oldhead.next = tempNext ;
                  count = 0;
                  prev = oldhead;

            }   

            temp =tempNext ;
            count++;
            
                 }

                 return ans.next;
        
    }

    public ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }

        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(temp, curr);
    }
}
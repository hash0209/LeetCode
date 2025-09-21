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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        int len = 1;

        ListNode temp = head;

        while(temp.next!=null){
            len++;
            temp = temp.next;
        }
        temp.next = head;

        if(k >= len){
           
            k = k%len;
        }


         k = len -k ;

         int count =0;

         temp = head;
         while(temp!=null){
            count++;
            if(count == k){
                break;
            }
            temp=temp.next;
            
         }

         head = temp.next;
         temp.next = null;
         return head ;


         






        
    }

 
}
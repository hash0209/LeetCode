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
        if(head == null || k == 0){
            return head;
        }

        int len = 0;

        ListNode temp = head;

        while(temp!=null){
            len++;
            temp = temp.next;
        }

        if(k >= len){
            if(k == len || k% len == 0){
                return head;
            }
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

         ListNode ans = temp.next;
         temp.next = null;
         ListNode dummy = ans;

         while(dummy.next!=null){
            dummy = dummy.next;
         }

         dummy.next = head;
         return ans;


         






        
    }

 
}
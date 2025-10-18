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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = head;
        

        while(node!=null){

            ListNode temp = node.next;

            while(temp != null &&  temp.val == node.val){
                temp = temp.next;
            }

            node.next = temp;
            node = node.next;
            
        }
        return head;



        
    }
}
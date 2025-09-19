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
        ListNode temp = head;

        while(node!=null){

            while(temp != null && temp.next!=null && temp.val == temp.next.val){
                temp = temp.next;
            }

            node.next = temp.next;
            node = node.next;
            temp = node;
        }
        return head;



        
    }
}
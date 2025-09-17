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
    public ListNode reverseKGroup(ListNode head, int k) {

        int count=0;
        ListNode prev = null;
        ListNode oldhead =null;
        ListNode temp = head;


        while(temp !=null){
            count++;
            if(count==1){
                oldhead =temp;
            }
            ListNode tail = temp.next;
            
            if(count == k){

               
                temp.next = null;
                
                ListNode newHead = reverse(null , oldhead);
                if(prev == null){
                    head =newHead;
                }
                else{
                prev.next = newHead;
                }
               
                oldhead.next = tail;
                prev = oldhead;
                count=0;
            }

            temp=tail;


        

        }

        return head;



        

    }

    public ListNode reverse(ListNode prev , ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev ; 
        return reverse(curr,temp);
    }


}
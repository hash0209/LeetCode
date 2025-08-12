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

        int count = 0;

        ListNode currhead = null;
        ListNode prev = new ListNode(-1);
        ListNode ans = prev ;


        while(head!=null){
              count++;

            if(count ==1){
                currhead= head;
            }

            ListNode next = head.next ;

            if(count == k){
                head.next = null ;
                ListNode reversedHead = reverse(currhead , null);
                currhead.next = next;
                prev.next = reversedHead;
                prev = currhead;
                count = 0;

            }

          
            head = next ;

        }

        return ans.next ;
    }

        

        public ListNode reverse(ListNode curr , ListNode prev){

            if(curr == null){
                return prev;
            }

            ListNode next = curr.next ;
            curr.next = prev ;
            return reverse(next , curr);
        }
    }

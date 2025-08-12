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
    public ListNode mergeKLists(ListNode[] lists) {

       
        if(lists.length == 0){
            return null;
        }

        ListNode l1 = lists[0];

        for(int i =1 ; i < lists.length ; i++){

            ListNode l2 =lists[i];
            l1 = merge(l1 , l2);
        }

        return l1;
        
    }

    public ListNode merge(ListNode l1 , ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 =l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy =dummy.next;
        }

        if(l1!=null){
            dummy.next =l1;
           
        }

        if(l2!=null){
            dummy.next =l2;
                   
    }

    return temp.next ;
}
}
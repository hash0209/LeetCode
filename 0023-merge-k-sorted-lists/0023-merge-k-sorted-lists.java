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

       return mergeHelper(0, lists.length-1 , lists);
        
    }

    public ListNode mergeHelper(int left , int right , ListNode[] lists){
        if(left == right){
            return lists[left];
        }
        int mid = (left+right)/2;

        ListNode l1 = mergeHelper(left , mid , lists);
        ListNode l2 = mergeHelper(mid+1 , right , lists);

        return merge(l1 , l2);
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
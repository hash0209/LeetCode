/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null){
            return head;
        }

        Node temp = head;

        Node n ;

        while(temp!=null){

            n= new Node(temp.val);
            n.next = temp.next;
            temp.next = n ;
            temp = temp.next.next;

        }

        temp = head;
        while(temp!=null){
            if(temp.random == null){
                temp.next.random = null;
            }
            else{
            temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node ans = new Node(-1);
        Node dummy = ans;

        temp = head;
        while(temp!=null){
            dummy.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            dummy=dummy.next;

        }
        return ans.next;

        
    }
}
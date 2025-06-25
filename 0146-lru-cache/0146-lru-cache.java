class LRUCache {

    int size =0;
    Map<Integer,Node> map ;
    int maxsize = 0;
    Node head =null;
    Node tail =null;



    public LRUCache(int capacity) {
        map = new HashMap<>();
        maxsize = capacity;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        if(null == map.get(key)){
            return -1;
        }


            Node n = map.get(key);
          //  n.val =value;
          //  map.put(key,n);

            if(n.prev != null){
                //node is not head

                //if(node is tail)
                if(n.next == null){
                    Node prevnode = n.prev ; 
                    prevnode.next = null; 
                    tail = prevnode;
                    
                }

                else{
                //if not tail 

                n.prev.next = n.next;
                n.next.prev = n.prev ;

                
                }
                    n.prev =null;
                    n.next = head;
                    head.prev = n;
                    head = n ;
            }


            return n.val;

        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) && null != map.get(key)){

            //replace and put as head
            Node n = map.get(key);
            n.val =value;
           

            if(n.prev != null){
                //node is not head

                //if(node is tail)
                if(n.next == null){
                    Node prevnode = n.prev ; 
                    prevnode.next = null; 
                    tail = prevnode;
                    
                }

                else{
                //if not tail 

                n.prev.next = n.next;
                n.next.prev = n.prev ;

                
                }
                    n.prev =null;
                    n.next = head;
                    head.prev = n;
                    head = n ;
            }
            
           

           


        }

        else{

            Node n = new Node(key , value);
            if(size ==0 ){
                head =n; tail = n ; 
                size ++;
                map.put(key , n);
            }
            else if(size < maxsize){
                n.next = head;
                if(head!=null){
                head.prev = n;
                }
                head =n;
                size++;
                map.put(key , n);
            }
            else{
                //remove tail 
                if(tail!=null){
                map.put(tail.key,null);
                }
                map.put(key,n);
                if (head == tail){
                    head =n;
                    tail = n;
                }
                else{
                    Node newtail = tail.prev;
                    tail.prev = null;
                    newtail.next = null;
                    tail = newtail ; 
                    n.next = head; 
                   // n.prev = null;
                    head.prev = n;
                    head =n;


                }
            }
        }
    }
}


class Node {
    int key ;
    int val ; 

    Node prev ;
    Node next ;

    public Node(){

    }

    public Node(int key , int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
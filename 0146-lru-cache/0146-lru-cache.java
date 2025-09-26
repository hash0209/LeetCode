class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int cap;
  

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();

    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        delete(n);
        insert(n);
        
        return n.val;

    }

    public void put(int key, int value) {
        Node n;
        if (map.containsKey(key)) {
            n = map.get(key);
            delete(n);
            n.val = value;
            insert(n);
            return;
        }
        if (map.size()==cap) {
            map.remove(tail.prev.key);
          
            delete(tail.prev);
        }
        

        n = new Node(key, value);
        map.put(key, n);
        insert(n);
       

    }

    public void insert(Node n) {
        Node temp = head.next;

        n.next = temp;
        temp.prev = n;

        head.next = n;
        n.prev = head;
    }

    public void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}

class Node {

    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
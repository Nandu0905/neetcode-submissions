class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer,Node>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next= tail;
        tail.prev= head; 
    }
        private void addToFront(Node node){
            node.next= head.next;
            node.prev=head;
            node.next.prev = node;
            head.next = node;
        }
        private void removeNode(Node node){
            node.next.prev =node.prev;
            node.prev.next =node.next;
        }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        removeNode(n);
        addToFront(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
            return;
        }
        Node newNode = new Node(key,value);
        if(map.size()==capacity){
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
        addToFront(newNode);
        map.put(key,newNode);
    }
}

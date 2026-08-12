class LRUCache {
    class Node{
        int val,key;
        Node(int key,int val){
            this.val=val;
            this.key=key;
        }
        Node prev,next;
    }
    Node head,tail;
    int capacity;HashMap<Integer,Node>map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node curr=map.get(key);
        remove(curr);
        insertFromStart(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            temp.val=value;
            remove(temp);
            insertFromStart(temp);return;
        }
        if(map.size()==capacity){
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node temp=new Node(key,value);
        insertFromStart(temp);
        map.put(key,temp);
    }
    public void remove(Node curr){
        Node prev=curr.prev;
        Node next=curr.next;
        prev.next=next;
        next.prev=prev;
    }
    public void insertFromStart(Node curr){
        Node temp=head.next;
        curr.next=temp;
        temp.prev=curr;
        curr.prev=head;
        head.next=curr;
    }
}

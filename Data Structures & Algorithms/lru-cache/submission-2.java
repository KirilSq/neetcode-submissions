class LRUCache {
    class Node {
        int value;
        Node prev;
        Node next;
        int key;

        public Node (int value, int key){
            this.value = value;
            this.key = key;
            prev = null;
            next = null;
        }

    }

    class DoublyLinkedList {
        Node newest;
        Node oldest;

        public void add(Node node){
            if(node == null) {
                return;
            }
            if (newest == null || oldest == null) {
                newest = node;
                oldest = node;
            }else {
                node.next = newest;
                node.prev = null;
                newest.prev = node;
                newest = node;

            }
        }
        public DoublyLinkedList() {
            newest = null;
            oldest = null;
        }
    }


    int capacity;
    HashMap<Integer, Node> map;
    DoublyLinkedList recencyList;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        recencyList = new DoublyLinkedList();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        removeNode(node);
        recencyList.add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null && map.size() == capacity){
            map.remove(recencyList.oldest.key);
            removeNode(recencyList.oldest);
        }
        
        if(node != null) {
            node.value = value;
            removeNode(node);
        }else {
            node = new Node(value, key);
            map.put(key, node);
        }
        recencyList.add(node);
    }

    private void removeNode(Node node){
        if(node == null) {
            return;
        }
        if(node == recencyList.newest) {
            recencyList.newest = node.next;
        }
        if(node == recencyList.oldest){
            recencyList.oldest = node.prev;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        
    }

}

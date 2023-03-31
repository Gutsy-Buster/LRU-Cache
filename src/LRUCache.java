import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void putKey(int key, int value) {
        if(!map.containsKey(key)) {
            if(capacity == map.size()) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
        }else {
            Node node = map.get(key);
            map.remove(key);
            deleteNode(node);
        }

        Node node = new Node(key, value);
        addNode(node);
        map.put(key, node);
    }

    public int getValue(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int val = node.value;
            deleteNode(node);
            addNode(node);
            map.replace(key, head.next);
            return val;
        }
        return -1;
    }
}

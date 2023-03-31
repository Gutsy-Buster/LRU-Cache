public class LRUMain {
    public static void main(String[] args) throws Exception {
        LRUCache lru = new LRUCache(2);
        lru.putKey(1, 1);
        lru.putKey(2, 2);
        System.out.println(lru.getValue(1));
        lru.putKey(3, 3);
        System.out.println(lru.getValue(2));
        lru.putKey(4, 4);
        System.out.println(lru.getValue(1));
        System.out.println(lru.getValue(3));
        System.out.println(lru.getValue(4));
    }
}

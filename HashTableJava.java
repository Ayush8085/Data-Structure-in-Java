public class HashTableJava {
    public static void main(String[] args) {

        HashTable table = new HashTable();
        
        System.out.println(table.isEmpty());

        table.put(105, "Ayush");
        table.put(5, "Chirag");
        table.put(23, "Ujjwal");

        System.out.println(table.size());
        System.out.println(table.remove(33));
        System.out.println(table.size());
        System.out.println(table.isEmpty());
    }
}

class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets; // Capacity
    private int size; // Number of key value pairs in the hashtable

    HashTable() {
        this(10); // Default capacity
    }

    HashTable(int capacity) {
        this.numOfBuckets = capacity; // Parameterized
        buckets = new HashNode[numOfBuckets];
    }

    // HashNode class
    private class HashNode {
        private int key; // can be of any data type
        private String value; // can be of any data type
        private HashNode next;

        HashNode(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Hash function
    private int getBucketIndex(int key) {
        return key % numOfBuckets;
    }

    public void put(int key, String value) {
        if(value == null) {
            throw new IllegalArgumentException("Value not found!!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while(head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    public String get(int key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while(head != null) {
            if(head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(int key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;

        while(head != null) {
            if(head.key == key) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        size--;
        if(prev != null) {
            prev.next = head.next;
        }
        else {
            buckets[bucketIndex] = head.next;
        }

        return head.value;
    }
}
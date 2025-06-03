package Hashing;

public class CustomHashMap<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; 
    private Node<K, V>[] table;


    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = (Node<K, V>[]) new Node[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; 
                return;
            }
            head = head.next;
        }

      
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

   
    public V get(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; 
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Node<K, V> head = table[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
}

class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("mango", 3);
        map.put("apple", 5); 

        System.out.println("Value for 'apple': " + map.get("apple"));
        System.out.println("Value for 'banana': " + map.get("banana"));
        map.display();
    }
}


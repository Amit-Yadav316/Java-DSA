package LinkedList;

class DoublyNode<T> {
    T value;
    DoublyNode<T> prev;
    DoublyNode<T> next;

    DoublyNode(T value) {
        this.value = value;
    }
}

public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void insertAtHead(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtTail(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(T target, T value) {
        DoublyNode<T> current = head;
        while (current != null && !current.value.equals(target)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + target + " not found.");
            return;
        }

        DoublyNode<T> newNode = new DoublyNode<>(value);
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; 
        }

        current.next = newNode;
    }

    public void deleteNode(T value) {
        DoublyNode<T> current = head;

        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + value + " not found.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; 
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }
    public void displayBackward() {
        DoublyNode<T> current = tail;
        while (current != null) {
            System.out.print(current.value);
            if (current.prev != null) System.out.print(" <=> ");
            current = current.prev;
        }
        System.out.println();
    }

}

class Demo {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtHead(10);
        dll.insertAtTail(20);
        dll.insertAtHead(5);
        dll.insertAfter(10, 15);
        dll.deleteNode(10);
        dll.displayBackward();
    }
}


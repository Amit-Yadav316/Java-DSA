package Queue;

// Deque implementation using a doubly linked list in Java
// A Deque (Double-Ended Queue) allows insertion and removal of elements from both ends.
class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}


public class Deque {
    private Node front, rear;
    private int size;

    public Deque() {
        front = rear = null;
        size = 0;
    }

    public void offerFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void offerLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int pollFirst()  {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return Integer.MIN_VALUE;
        }
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        else front.prev = null;
        size--;
        return value;
    }

    public int pollLast()  {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return Integer.MIN_VALUE;
        }
        int value = rear.data;
        rear = rear.prev;
        if (rear == null) front = null;
        else rear.next = null;
        size--;
        return value;
    }

    public int peekFirst()  {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    public int peekLast()  {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }

  
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node current = front;
        System.out.print("Deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
class demo {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerFirst(5);
        deque.display(); 

        System.out.println("Poll First: " + deque.pollFirst());
        deque.display();

        System.out.println("Poll Last: " + deque.pollLast());
        deque.display();
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());
    }
}


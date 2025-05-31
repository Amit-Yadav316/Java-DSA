package Queue;

// Queue implementation using a linked list in Java
// This code defines a Queue class with methods to enqueue, dequeue, peek, check if the queue is empty, and display the queue contents.
//queue is the FIFO (First In First Out) data structure, where elements are added to the rear and removed from the front.

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue()  {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public int peek()  {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class demo {
    public static void main(String[] args) {
            Queue queue = new Queue();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.display(); 

            System.out.println("Dequeue: " + queue.dequeue());
            queue.display();
            System.out.println("Peek: " + queue.peek());
            System.out.println("Queue size: " + queue.size());
    }
}

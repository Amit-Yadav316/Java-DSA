package Queue;
//circular queue implementation in Java
//using array and linked list


//1. Circular Queue using Array
public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        arr[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// using circular linked list
class CircularLinkedListQueue {
    private Node rear; 
    private int size;

    public CircularLinkedListQueue() {
        rear = null;
        size = 0;
    }


    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            rear = newNode;
            rear.next = rear;
        } else {
            newNode.next = rear.next; 
            rear.next = newNode;     
            rear = newNode;          
        }
        size++;
    }


    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        Node front = rear.next;

        if (rear == front) {
            rear = null;
        } else {
            rear.next = front.next; 
        }

        size--;
        return front.data;
    }


    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.next.data;
    }

    public boolean isEmpty() {
        return rear == null;
    }


    public int size() {
        return size;
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = rear.next; 
        System.out.print("Queue: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != rear.next);
        System.out.println();
    }
}

class Demo {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        CircularLinkedListQueue clq = new CircularLinkedListQueue();
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.display(); 

        System.out.println("Dequeue: " + cq.dequeue()); 
        cq.display();

        System.out.println("Peek: " + cq.peek()); 
        System.out.println("Size: " + cq.size()); 
        cq.enqueue(60); 
        cq.display();
        // Testing Circular Linked List Queue
        System.out.println("Testing Circular Linked List Queue:");
        clq.enqueue(10);
        clq.enqueue(20);
        clq.enqueue(30);
        clq.enqueue(40);
        clq.enqueue(50);
        clq.display();
        System.out.println("Dequeue: " + clq.dequeue());
        clq.enqueue(70);
        clq.display();  
    }
}

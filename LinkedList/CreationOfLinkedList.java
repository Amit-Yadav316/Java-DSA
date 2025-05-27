package LinkedList;
// This is the creation of singly linked list in java
// linked list are a linear data stuctures which are used to store elements in a sequential manner where each element is a separate object, and each object (node) contains a reference (link) to the next node in the sequence. This allows for efficient insertion and deletion of elements, as opposed to arrays which require shifting elements when inserting or deleting.
// they can be used to implement stacks , queues, and other data structures. Linked lists can be singly linked (where each node points to the next node) or doubly linked (where each node points to both the next and previous nodes). They are dynamic in nature, meaning they can grow and shrink in size as needed, unlike arrays which have a fixed size.
// Linked lists are commonly used in applications where frequent insertion and deletion of elements is required, such as in implementing dynamic memory allocation, managing resources, and maintaining ordered collections.
public class CreationOfLinkedList {
    Node<Integer> head ;
    int size;

    public CreationOfLinkedList() {
        this.head=null ;
        this.size = 0;
    }
    public void inserthead(int data) {
        Node<Integer> newNode = new Node<>(data) ;
        if(head==null) {
            head = newNode;
            size++;
            return ;
        }
        newNode.next = head ;
        head = newNode ;
        size++;
    }  
    public void inserttail(int data) {
         Node<Integer> newNode = new Node<>(data) ;
        if(head==null) {
            head = newNode;
            size++;
            return ;
        }
        Node<Integer> current = head ;
        while(current.next != null) {
            current = current.next ;
        }
        current.next = newNode ;
        size++;
    }
    public void insertNode(int data , int position) {
        Node<Integer> newNode = new Node<>(data) ;
        if(head==null) {
            head = newNode;
            size++;
            return ;
        }
        if(position == 0) {
            newNode.next = head ;
            head = newNode ;
            size++;
            return ;
        }
        if(position > size) {
            System.out.println("Position out of bounds");
            return ;
        }
        Node<Integer> current = head ;
        for(int i=0 ; i<position-1 && current!=null ; i++) {
            current = current.next ;
        }
        if(current == null) {
            System.out.println("Position out of bounds");
            return ;
        }
        newNode.next = current.next ;
        current.next = newNode ;
        size++;
    }
    public void deletehead() {
        if(head == null) {
            System.out.println("list is empty deletion not possible");
            return ;
        }
        Node<Integer> current = head ;
        head = head.next ;
        current.next = null; // optional, helps with garbage collection
        size--;
    }
    public void deleteTail() {
        if(head==null) {
            System.out.println("list is empty deletion not possible");
            return ;
        }
        Node<Integer> current = head ;
        if(current.next == null) {
            head = null; // if only one node is present
            size--;
            return ;
        }
        while(current.next.next != null) {
            current = current.next ;
        }
        current.next = null; // remove the last node
        size--;
    }
    public void deleteNode(int position) {
        if(head == null) {
            System.out.println("list is empty deletion not possible");
            return ;
        }
        if(position == 0) {
            head = head.next; // delete the head node
            size--;
            return ;
        }
        if(position >= size) {
            System.out.println("Position out of bounds");
            return ;
        }
        if(position == size - 1) {
            deleteTail(); // if position is equal to size, delete the tail
            return ;
        }
        Node<Integer> current = head ;
        while(current.next != null && position > 1) {
            current = current.next ;
            position--;
        }
        current.next = current.next.next ;
        size--;
    }
    public void display() {
        if(head == null) {
            System.out.println("List is empty");
            return ;
        }
        Node<Integer> current = head ;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next ;
        }
        System.out.println("null");
    }
}
class Node<T> {
    T data ;
    Node<T> next ;
    Node() {
        this.next= null ;
    }
    Node(T data) {
        this.data = data ;
        this.next = null ;
    }
}
class LinkedListDemo {
    public static void main(String[] args) {
        CreationOfLinkedList list = new CreationOfLinkedList();
        list.inserthead(10);
        list.inserttail(20);
        list.insertNode(15, 1);
        list.display(); // 10 -> 15 -> 20 -> null
        list.deletehead();
        list.display(); // 15 -> 20 -> null
        list.deleteTail();
        list.display(); // 15 -> null
        list.insertNode(25, 1);
        list.display(); // 15 -> 25 -> null
        list.deleteNode(0);
        list.display(); // 25 -> null
    }
}
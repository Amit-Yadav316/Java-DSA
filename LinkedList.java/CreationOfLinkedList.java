package LinkedList.java;

public class CreationOfLinkedList {
    Node<Integer> head ;

    public CreationOfLinkedList() {
        this.head=null ;
    }
    
}
class Node<T> {
    T data ;
    Node next ;
    Node() {
        this.next= null ;
    }
    Node(T data) {
        this.data = data ;
        this.next = null ;
    }
}
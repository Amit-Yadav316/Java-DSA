package Stack;
//this is a Static stack which means you have to give size using object call.


public class CreationOfStack {
    int stack[];
    int top;
    int size;
    CreationOfStack(int size){
        this.top = -1 ;
        this.size=size;
        this.stack=new int[size] ;
    }
    void push(int num){
        if(top==size-1) {
            System.out.println("Stack is full");
            return ;
        }
        top++;
        stack[top] = num ;
        return;
    }
    boolean isEmpty(){
        if(top==-1) {
            return true ;
        }
        return false ;
    }
    int peek(){
        if(isEmpty()) {
            System.out.println("stack is Empty");
            return Integer.MIN_VALUE ;
        }
        int val = stack[top] ;
        return val ;
    }
    int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE ;
        }
        int val = peek() ;
        top-- ;
        return val ;
    }
}
class demo{
    public static void main(String[] args) {
        CreationOfStack obj = new CreationOfStack(10) ;
        obj.push(3) ;
        obj.push(4) ;
        obj.push(10) ;
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}

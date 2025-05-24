package ObjectOrientedProgramming;

public class Encapsulation {
    // Access modifiers are keywords that set the accessibility of classes, methods, and other members.
    // The four access modifiers in Java are: public, private, protected, and default (package-private).
    // Getter and setter methods are used to access and update the private variables of a class.
    private String name = "Default";
    private int size ;
    public int rollno;
    // Getter and Setter methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
}
// for best practices, create another class to demonstrate encapsulation
// This is a simple Java program that demonstrates the concept of encapsulation.
class EncapsulationDemo {
public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        obj.rollno = 101;
        System.out.println("Roll No: " + obj.rollno);//we can change the value of rollno as it is public and this is bad practice as everyone has access to it.
        //obj.name = "New Name"; // This will give an error as name is private
        System.out.println("Initial Name: " + obj.getName());
        obj.setName("New Name");
        obj.setSize(10);
        System.out.println("Initial Size: " + obj.getSize());
        System.out.println("Updated Name: " + obj.getName());
    }
}

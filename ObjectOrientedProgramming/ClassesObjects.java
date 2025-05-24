//Object Oriented Programming
// This code demonstrates the concept of classes and objects in Java.
// It demostrates the concept of constructors.
// In OOPs, variables and funcitons are called attributes and methods respectively.
// Classes does not have any memory when we create a object of the classthen only memory is allocated.

package ObjectOrientedProgramming;

class ClassesObjects {
    int size;
    String name;
    ClassesObjects(int size, String name) {
        this.size = size;
        this.name = name;
    }
    public void display() {
        System.out.println("Size: " + size + ", Name: " + name);
    }
    public static void main(String[] args) {
        ClassesObjects obj1 = new ClassesObjects(10, "Object1");
        ClassesObjects obj2 = new ClassesObjects(16, "Object2");
        obj1.display();
        obj2.display();
    }
}
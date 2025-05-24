package ObjectOrientedProgramming;

public class Inheritance {
    int size;
    String name;
    Inheritance() {
        this.size = 0 ;
        this.name = "Amit" ;
    }
    void display(){
        System.out.println("Name" + name );
        System.out.println("Size" + size);
    }
    void print() {
        System.out.println("Hii My name is Amit yadav");
    }
}
class Child extends Inheritance {
    int rollNo ;
    String type ;
    Child() {
        super();
        this.rollNo = 0 ;
        this.type = "boy" ;
    }
    @Override
    void display(){
        super.display();//it will call the parent class 
        System.out.println("RollNo" + rollNo );
        System.out.println("type" + type);
    }
}

class Demo {
public static void main(String[] args) {
    Inheritance obj = new Inheritance() ;
    Child obj1 = new Child() ;
    Inheritance obj2 = new Child() ;
    obj.display() ;
    obj1.display();
    obj2.display(); //this is function overriding which will print the child class display.
    obj1.print(); // you can call from your parent class this is usefull so you dont have to go to parent  class everytime.
}
}
//There are other type of inheritance as well like hierearchal , mutiple inheritance but most of them have same use as well just extends changes.
// Multiple inheritance have a diamond problem which we to parent class has same function it cant decide on its  own which to choose so the only one which can do it is Interfaces.
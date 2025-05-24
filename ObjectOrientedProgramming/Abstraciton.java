package ObjectOrientedProgramming;

abstract class Abstraciton {
    int size ;
    public Abstraciton() {
        this.size=0;
    }
    public abstract  void display();
}

class child extends Abstraciton{
    public void display() {
    System.out.println("hi this is alpha35");
    }
    }
interface demoInterface {
    void display() ;
}

class child1 implements demoInterface {
    public void display() {
        System.out.println("hi this is alpha35");
    }
}
// differnce between abstract class and interface is that abstract class can have both abstract and non-abstract methods whereas interface can only have abstract methods and it is stateless.
// also abstract class can have constructors and instance variables whereas interface cannot have constructors and instance variables.
// abstract class can extend another class and implement an interface whereas interface can only extend another interface.
// interface method is public and abstract by default, whereas abstract class method can have any access modifier.
// multiple inheritance is not allowed in java but we can implement multiple interfaces in java.


class demo {
    public static void main(String[] args) {
        Abstraciton obj = new child() ;
        obj.display() ;
        // Abstraciton obj1 = new Abstraciton() ; // this is not allowed as we cannot create an object of abstract class
        demoInterface obj2 = new child1() ;
        obj2.display() ;
        // demoInterface obj3 = new demoInterface() ; // this is not allowed as we cannot create an object of interface
    }
}



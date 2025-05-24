package ObjectOrientedProgramming;

/*Static binding (a.k.a. early binding) means the method call is resolved at compile time.

Java uses static binding for:

Static methods

Private methods

Final methods */
class Polymorphism {
    int num;
    String name;

    public Polymorphism() { 
        this.num=0;
        this.name="Amit" ;
    }
    // this two constructor is an example of function overloading 
    public Polymorphism(int num, String name) {
        this.num=num;
        this.name=name;
    }
    protected void start() {
        System.out.println("Hi this function can start");
    }
    static void print() {
        // this.num=0; this is not allowed as static method can only access static variable
        System.out.println("hi my name is amit");
    }

    
}

class child extends Polymorphism{
    public child() {
        super() ;
    }
    /*default void start() { 
        System.out.println("hi my name is Eminem");
    } */ 
   // this upper function is giving me an error because the priority order is public , protected , default ,private. here we have used default hence the upper must be default. 
    @Override
    public void start() { 
        System.out.println("hi my name is Eminem");
}
}
class demo {
    public static void main(String[] args) {
        Polymorphism obj = new Polymorphism() ;
        child obj1 = new child() ;
        Polymorphism obj2 = new child() ;
        obj1.start() ;
        obj2.start() ;
}
}

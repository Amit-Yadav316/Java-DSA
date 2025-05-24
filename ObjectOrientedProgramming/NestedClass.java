package ObjectOrientedProgramming;
// types of nested clases in java are:
// 1. Inner class
// 2. Static nested class
// 3. Method-local inner class
// 4. Anonymous inner class


public class NestedClass {
    static int num;
    static String name;
// 1. Inner class
    class InnerClass {
        void display() {
            System.out.println("This is an inner class");
        }
    }

// 2. Static nested class
// in static nested class we can access static variables of outer class but we cannot access non-static variables of outer class directly.
    public static class StaticNestedClass {
        void display() {
            System.out.println("This is a static nested class");
             System.out.println("Number: " + num);
             System.out.println("Name: " + name);
        }
    }

// 3. Method-local inner class
    void methodLocalInnerClass() {
        class MethodLocalInnerClass {
            void display() {
                System.out.println("This is a method-local inner class");
            }
        }
        MethodLocalInnerClass obj = new MethodLocalInnerClass();
        obj.display();
    }
}
interface dog {
    void sound();
}

class Demo {
    public static void main(String[] args) {
        NestedClass outer = new NestedClass();
        outer.methodLocalInnerClass();
        NestedClass.InnerClass inner = outer.new InnerClass();
        inner.display();
        NestedClass.StaticNestedClass staticNested = new NestedClass.StaticNestedClass();
        staticNested.display();
        // 4. Anonymous inner class
        dog d = new dog() {
            public void sound() {
                System.out.println("Dog barks");
            }
        };
        d.sound();
    }
}


package ObjectOrientedProgramming;

public class Generics<T> {
    T value ;
    public Generics() {
        this.value = null;

    }
    public Generics(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
interface GenericInterface<T> {
    T getValue();     
}
class child<T> implements GenericInterface<T> {
     T value;

    public child(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
// List<Integer> list = new ArrayList<>(); List is a interface in java but ArrayList is a class that implements List interface
class demo {
    public static void main(String[] args) {
        Generics<String> obj = new Generics<>("Hello");
        System.out.println(obj.getValue());
        Generics<Integer> obj2 = new Generics<>(123);
        System.out.println(obj2.getValue());
        child<String> childObj = new child<>("World");
        System.out.println(childObj.getValue());
    }
}
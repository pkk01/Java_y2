class GenericClass<T> {
    T obj;

    GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

public class GenericClassMain {
    public static void main(String[] args) {
        GenericClass<Integer> i = new GenericClass<>(200);
        System.out.println(i.getObject());
        GenericClass<String> j = new GenericClass<>("Hello");
        System.out.println(j.getObject());

    }
}

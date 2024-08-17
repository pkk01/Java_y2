class Generics<P> {
    P obj;

    Generics(P obj) {
        this.obj = obj;
    }

    public void printObj() {
        System.out.println("The Generic type is: " + this.obj);
    }
}

public class GenericClassMain {
    public static void main(String[] args) {
        Generics g = new Generics<Integer>(500);
        g.printObj();
    }
}

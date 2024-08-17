class GenericMethod {
    public <T> void getMethod(T data) {
        System.out.println("Generic Method");
        System.out.println("Data passed: " + data);
    }
}

public class GenericMethodMain {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.<String>getMethod("hello I am Generic Method");
        gm.<Integer>getMethod(1243);
    }
}

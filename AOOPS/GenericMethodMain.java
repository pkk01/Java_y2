class GenericMethod {
    public <T> void getMethod(T data) {
        System.out.println("Generic Method");
        System.out.println("Data Passed: " + data);
    }
}

public class GenericMethodMain {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.<String>getMethod("Hello and thanks");
        gm.<Integer>getMethod(200);
        gm.<Double>getMethod(250d);
    }
}
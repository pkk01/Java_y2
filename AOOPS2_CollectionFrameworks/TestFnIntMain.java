public class TestFnIntMain {
    interface Fun1 {
        int operation(int a, int b);
    }

    interface Fun2 {
        void message(String msg);
    }

    private int operate(int a, int b, Fun1 obj1) {
        return obj1.operation(a, b);
    }

    public static void main(String[] args) {
        Fun1 add = (int x, int y) -> x + y;
        Fun1 mul = (int x, int y) -> x * y;
        TestFnIntMain obj = new TestFnIntMain();
        System.out.println("Addition: " + obj.operate(3, 4, add));
        System.out.println("Multiplication: " + obj.operate(3, 4, mul));

        Fun2 f2 = msg -> System.out.println("Hello " + msg);
        f2.message("KLU");
    }
}

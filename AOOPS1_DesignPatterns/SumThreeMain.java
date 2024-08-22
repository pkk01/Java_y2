public class SumThreeMain<T> {
    T num1;
    T num2;
    T num3;

    public SumThreeMain(T num1, T num2, T num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public void sum() {
        double sum = (double) ((Integer) num1 + (Integer) num2 + (Integer) num3);
        System.out.println("Sum of three: " + sum);
    }

    public static void main(String[] args) {
        SumThreeMain<Integer> s = new SumThreeMain<>(12, 13, 14);
        s.sum();
    }

}

package Year2;
class EagerInitialisation {
    private EagerInitialisation() {
    }

    private static EagerInitialisation theOnlyInstance = new EagerInitialisation();

    public static EagerInitialisation getInstance() {
        return theOnlyInstance;
    }
}

public class Singleton {
    public static void main(String[] args) {
        EagerInitialisation e1 = EagerInitialisation.getInstance();
        EagerInitialisation e2 = EagerInitialisation.getInstance();
        if (e1 == e2) {
            System.out.println("Both are same");
        } else {
            System.out.println("Both are diffrent");
        }
    }
}
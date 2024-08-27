class Single {
    static Single obj = new Single();

    static Single getObject() {
        return obj;
    }

    private Single() {
        // left blank so that no instances can be created
    }

    void display() {
        System.out.println("Hii I am single class");
    }
}

public class SingletonMain {
    public static void main(String[] pk) {
        Single s1 = Single.getObject();
        s1.display();
        Single s2 = Single.getObject();
        s2.display();
    }
}
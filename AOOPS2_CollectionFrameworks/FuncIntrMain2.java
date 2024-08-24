interface Eatable {
    void eat();
}

// class One implements Eatable {
// public void eat () {
// System.out.println("Eating sweeets");
// System.out.println("Eating fruites");
// }
// }
public class FuncIntrMain2 {
    public static void main(String[] args) {
        Eatable e = () -> {
            System.out.println("Eating sweets");
            System.out.println("Eating fruits");
        };
        e.eat();
    }
}

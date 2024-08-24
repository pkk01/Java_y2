interface Eatable {
    void eat(String a, String b);
}

// class One implements Eatable {
// public void eat () {
// System.out.println("Eating sweeets");
// System.out.println("Eating fruites");
// }
// }
public class FuncIntrMain3 {
    public static void main(String[] args) {
        Eatable e = (String a, String b) -> {
            System.out.println("Eating " + a);
            System.out.println("Eating " + b);
        };
        e.eat("Sweets", "Fruits");
    }
}

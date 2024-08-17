import java.util.*;

public class MapDemo {
    public static void main(String args[]) {
        Map<Integer, String> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();
        m1.put(1, "Srinisha");
        m1.put(2, "Pranithi");
        m1.put(3, "Gannavika");
        m2.put(1, "Jishu");
        m2.put(2, "Lohit");
        m2.put(3, "Madhu");

        System.out.println("m1 list: " + m1);
        System.out.println("m2 list: " + m2);
    }
}
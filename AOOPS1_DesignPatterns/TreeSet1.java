import java.util.*;

public class TreeSet1 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Apple");
        ts.add("Banana");
        ts.add("Cherry");
        ts.add("DatesBerry");
        ts.add("E fruit");
        Iterator<String> i = ts.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        System.err.println(ts);
    }
}
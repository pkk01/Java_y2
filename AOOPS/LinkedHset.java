import java.util.LinkedHashSet;
import java.util.*;

public class LinkedHset {
    public static void main(String[] args) {
        Set<String> c = new LinkedHashSet<String>();
        c.add("India");
        c.add("Australia");
        c.add("Russia");
        c.add("Spain");
        c.add("India");
        System.out.println("list of country: " + c);
        Iterator<String> i = c.iterator();
        while (i.hasNext()) {
            System.out.println(i.next);
        }
    }
}

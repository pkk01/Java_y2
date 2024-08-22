import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSets1 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();
        hs.add("Pavan");
        hs.add("Gopika");
        hs.add("Salif");
        hs.add("abhigyan");
        hs.add("Salif");
        System.out.println("List of elements: " + hs);
        Iterator<String> i = hs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

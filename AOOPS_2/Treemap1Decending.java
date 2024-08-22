import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Treemap1Decending {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Naresh", 99543);
        tm.put("Suresh", 88543);
        tm.put("Mahesh", 55433);
        NavigableMap<String, Integer> dmap = tm.descendingMap();
        System.out.println("Reverse navigable map values: " + dmap);
        Iterator<String> i = dmap.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            int value = dmap.get(key);
            System.out.println(key + " " + value);
        }

    }
}

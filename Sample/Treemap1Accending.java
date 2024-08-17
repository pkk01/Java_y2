import java.util.Map;
import java.util.TreeMap;

public class Treemap1Accending {
    public static void main(String[] args) {
        Map<String, Integer> tm = new TreeMap<>();
        tm.put("Naresh", 99543);
        tm.put("Suresh", 88543);
        tm.put("Mahesh", 55433);
        tm.put("Abhaya", 77654);
        for (Map.Entry<String, Integer> m : tm.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}

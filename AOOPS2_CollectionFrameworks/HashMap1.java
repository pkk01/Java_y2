import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Naresh", 99543);
        hm.put("Suresh", 88543);
        hm.put("Mahesh", 55433);
        for (Map.Entry<String, Integer> m : hm.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap1 {
    public static void main(String[] args) {
        Map<String, Integer> lm = new LinkedHashMap<>();
        lm.put("Naresh", 99543);
        lm.put("Suresh", 88543);
        lm.put("Mahesh", 55433);
        for (Map.Entry<String, Integer> m : lm.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}

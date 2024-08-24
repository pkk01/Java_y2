import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Rhoda Ellis", 1235);
        hm.put("Seth Griffin", 1062);
        hm.put("Daisy Medina", 2022);
        hm.put("Genevieve Dean", 1262);
        hm.put("Connor Griffith", 1866);
        hm.put("Ryan Greer", 1820);
        hm.put("Catherine Baker", 1057);
        hm.put("Trevor Sanders", 1394);
        hm.put("Jimmy Gutierrez", 1263);
        hm.put("Brian Sparks", 1754);
        hm.put("Sam Cross", 1679);
        hm.put("Pearl Vaughn", 1508);
        hm.put("Alex Ruiz", 1151);
        hm.put("Duane Padilla", 1699);
        hm.put("Lillian Ramos", 1634);
        for (Map.Entry<String, Integer> m : hm.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}

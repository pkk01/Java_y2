import java.util.LinkedList;

class TakeString {
    LinkedList<Character> ll = new LinkedList<>();
    PriorityQueue <Character> pq = new PriorityQueue<>();

    public String checkChar(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {

            ll.add(s.charAt(i));
        }
    }
}

public class Skill_Week6_1 {
    public static void main(String[] args) {
        TakeString ts = new TakeString();
        ts.checkChar("Hello");
    }
}

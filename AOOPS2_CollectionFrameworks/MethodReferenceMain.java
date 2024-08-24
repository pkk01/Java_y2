import java.util.Arrays;
import java.util.List;

public class MethodReferenceMain {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] pk) {
        List<String> msgs = Arrays.asList("Annes", "Taj", "Pranav", "Srishti");
        System.out.println("Using function Interface");
        msgs.forEach(msg -> MethodReferenceMain.print(msg));
        System.out.println("Using Method Reference Interface");
        msgs.forEach(MethodReferenceMain::print);

        msgs.forEach(msg -> System.out.println(msg));
        msgs.forEach(System.out::println);
    }
}

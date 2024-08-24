import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIMain {
    public static void main(String[] pk) {

        // Maps
        List<String> names = Arrays.asList("Ethel", "Barbara", "Lettie", "Harriet", "Lucille");
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Upper Case Name: " + upper);

        // FlatMap
        List<List<Integer>> num = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
        List<Integer> flatmap = num.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("FlatMap: " + flatmap);

        // fillter

        List<Integer> num2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even = num2.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Filter: " + even);

        // Collect
        List<String> names2 = Arrays.asList("Ethel", "Barbara", "Lettie", "Harriet", "Lucille");
        String joinedNames = names2.stream().collect(Collectors.joining(" || "));
        System.out.println("Collect: " + joinedNames);

        // Parallel Stream

        List<Integer> num3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = num3.parallelStream().reduce(2, Integer::sum);
        System.out.println("Parallel Stream: " + sum);
    }

}

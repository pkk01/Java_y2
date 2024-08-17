import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.addAll(Arrays.asList(new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
        Set<Integer> s2 = new HashSet<>();
        s2.addAll(Arrays.asList(new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));
        Set<Integer> Union = new HashSet<Integer>(s1);
        Union.addAll(s2);
        System.out.println("Union of the elements: " + Union);
        Set<Integer> Intersection = new HashSet<Integer>(s1);
        Intersection.retainAll(s2);
        System.out.println("Intersection of the elements: " + Intersection);
        Set<Integer> Difference = new HashSet<Integer>(s1);
        Difference.removeAll(s2);
        System.out.println("Difference of the elements: " + Difference);

    }
}

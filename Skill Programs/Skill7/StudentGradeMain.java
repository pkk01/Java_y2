import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.*;

class StudentGrade {
    private String subject;
    private double grade;

    public StudentGrade(String subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }
}


class AverageGradeCollector 
    implements Collector<StudentGrade, Map<String, List<Double>>, Map<String, Double>> {

    @Override
    public Supplier<Map<String, List<Double>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, List<Double>>, StudentGrade> accumulator() {
        return (map, studentGrade) -> 
            map.computeIfAbsent(studentGrade.getSubject(), k -> new ArrayList<>()).add(studentGrade.getGrade());
    }

    @Override
    public BinaryOperator<Map<String, List<Double>>> combiner() {
        return (map1, map2) -> {
            map2.forEach((key, value) -> 
                map1.merge(key, value, (list1, list2) -> { 
                    list1.addAll(list2); 
                    return list1; 
                })
            );
            return map1;
        };
    }

    @Override
    public Function<Map<String, List<Double>>, Map<String, Double>> finisher() {
        return map -> {
            Map<String, Double> result = new HashMap<>();
            map.forEach((subject, grades) -> {
                double avg = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                result.put(subject, avg);
            });
            return result;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.noneOf(Characteristics.class);
    }
}


public class StudentGradeMain {
    public static void main(String[] args) {
        List<StudentGrade> grades = Arrays.asList(
            new StudentGrade("Math", 85.5),
            new StudentGrade("Math", 90.0),
            new StudentGrade("Math", 78.5),
            new StudentGrade("Science", 88.0),
            new StudentGrade("Science", 92.5),
            new StudentGrade("Science", 84.0),
            new StudentGrade("History", 75.0),
            new StudentGrade("History", 80.5),
            new StudentGrade("History", 82.0)
        );

        Map<String, Double> averageGrades = grades.parallelStream()
            .collect(new AverageGradeCollector());

        averageGrades.forEach((subject, avg) -> 
            System.out.println(subject + ": " + avg));
    }
}

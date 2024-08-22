import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int regdno;
    String name;
    int age;

    Student(int regdno, String name, int age) {
        this.regdno = regdno;
        this.age = age;
        this.name = name;

    }
}

class AgeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.age == s2.age) {
            return 0;
        } else if (s1.age > s2.age) {
            return 1;
        } else {
            return -1;
        }
    }
}

class NameComaparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class ComparatorMain {
    public static void main(String[] args) {
        ArrayList<Student> as = new ArrayList<>();
        as.add(new Student(1, "Naresh", 12));
        as.add(new Student(2, "Mukesh", 21));
        as.add(new Student(3, "Kamlesh", 22));
        System.out.println("Comparing by age");

        Collections.sort(as, new AgeComparator());
        for (Student st : as) {
            System.out.println(st.regdno + " " + st.name + " " + st.age);
        }
        System.out.println("Comparing by name");

        Collections.sort(as, new NameComaparator());
        for (Student st : as) {
            System.out.println(st.regdno + " " + st.name + " " + st.age);
        }
    }
}

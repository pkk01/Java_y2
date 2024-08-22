import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }
}

public class AnonymousMain {
    public static void main(String[] args) {
        List<Student> st = new ArrayList<>();
        st.add(new Student("Suresh", 101));
        st.add(new Student("Mahesh", 231));
        st.add(new Student("Kamlesh", 103));
        st.add(new Student("Suraj", 211));

        // Sorting List Using Anonymous Class

        Collections.sort(st, new Comparator<Student>()  {
            public int compare(Student s1, Student s2) {
                return s1.getId() - s2.getId();
            }
        });

        for (Student student : st) {
            System.out.println(student);
        }
    }
}

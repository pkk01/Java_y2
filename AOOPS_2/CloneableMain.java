class Student implements Cloneable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneableMain {
    public static void main(String[] args) {
        Student s = new Student(2989, "kalki");
        System.out.println("Before cloning");
        System.out.println(s.id + " " + s.name);
        try {
            Student s1 = (Student) s.clone();
            System.out.println("After cloning");
            System.out.println(s1.id + " " + s1.name);
        } catch (Exception e) {
            System.out.println(s.toString());
        }
    }
}

class University {
    private String UName;

    public University(String UName) {
        this.UName = UName;
    }

    // Inner class
    class Student {
        private String sName;
        private int id;

        public Student(String sName, int id) {
            this.sName = sName;
            this.id = id;
        }

        public void studentInfo() {
            System.out.println("Student name: " + sName);
            System.out.println("Student Id: " + id);
            System.out.println("Student University Name: " + UName);
        }
    }
}

public class InnerClass_NestedClassMain {
    public static void main(String[] args) {
        University u = new University("KL University");
        University.Student st = u.new Student("Pratham", 33813);
        st.studentInfo();
    }
}

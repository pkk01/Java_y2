class University {
    private String UName;

    public University(String UName) {
        this.UName = UName;
    }

    // static nested Class
    public void uniInfo() {
        System.out.println("University: " + UName);
    }

    static class Dept {
        public String dName;

        public Dept(String dName) {
            this.dName = dName;
        }

        public void deptInfo() {
            System.out.println("Dept: " + dName);
        }
    }
}

public class Static_NestedClassMain {
    public static void main(String[] args) {
        // static class no instance required
        University university = new University("KLEF");
        University.Dept dept = new University.Dept("CSIT/CSE");
        dept.deptInfo();
        university.uniInfo();
    }
}

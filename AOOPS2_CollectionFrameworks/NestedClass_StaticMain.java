class University {
    private String uName;

    static class Dept {
        String deptName;

        public Dept(String deptName) {
            this.deptName = deptName;
        }

    }
    public University(String uName) {
        this.uName = uName;
    }

    public void display() {
        System.err.println("University: "+uName+" department: " + deptName);
    }
}

public class NestedClass_StaticMain {
    public static void main(String[] args) {
        University.Dept u = new University.Dept("CSIT");
        u.display();
    }

}

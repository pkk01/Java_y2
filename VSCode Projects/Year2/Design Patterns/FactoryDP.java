package Year2;

interface Employee {
    int salary();
}

class AndroidDeveloper implements Employee {
    public int salary() {
        System.out.println("Android Developer Salary");
        return 50000;
    }
}

class WebDeveloper implements Employee {
    public int salary() {
        System.out.println("Web Developer Salary");
        return 40000;
    }
}

class EmployeeFactory {
    public static Employee getIEmployee(String empType) {
        if (empType.trim().equalsIgnoreCase("Android Developer")) {
            return new AndroidDeveloper();
        } else if (empType.trim().equalsIgnoreCase("Web Developer")) {
            return new WebDeveloper();
        } else {
            return null;
        }
    }
}

public class FactoryDP {
    public static void main(String[] args) {
        Employee em;
        em = EmployeeFactory.getIEmployee("Android developer");
        System.out.println(em);
        int salary = em.salary();
        System.out.println("Salary: " + salary);
    }
}

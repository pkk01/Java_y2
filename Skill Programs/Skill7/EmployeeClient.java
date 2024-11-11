import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;
    private String department;
    private int yearsOfExperience;

    public Employee(String name, double salary, String department, int yearsOfExperience) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", " + yearsOfExperience + " years, $" + salary + ")";
    }
}

@FunctionalInterface
interface EmployeeFilter {
    boolean filter(Employee employee);
}
class EmployeeFilterDemo {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 80000, "HR", 5),
            new Employee("Bob", 95000, "IT", 8),
            new Employee("Charlie", 120000, "Finance", 12),
            new Employee("David", 70000, "IT", 3)
        );

        EmployeeFilter salaryFilter = e -> e.getSalary() > 75000;
        EmployeeFilter departmentFilter = e -> e.getDepartment().equals("IT");
        EmployeeFilter experienceFilter = e -> e.getYearsOfExperience() >= 5;

        List<Employee> filteredEmployees = employees.stream()
            .filter(e -> salaryFilter.filter(e) && departmentFilter.filter(e) && experienceFilter.filter(e))
            .collect(Collectors.toList());

        filteredEmployees.forEach(System.out::println);
    }
}

public class EmployeeClient {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 80000, "HR", 5),
            new Employee("Bob", 95000, "IT", 8),
            new Employee("Charlie", 120000, "Finance", 12),
            new Employee("David", 70000, "IT", 3),
            new Employee("Eve", 130000, "HR", 10)
        );

        List<Employee> filteredEmployees = filterEmployees(employees, 
            e -> e.getSalary() > 75000, 
            e -> e.getDepartment().equals("IT"), 
            e -> e.getYearsOfExperience() >= 5  
        );

        System.out.println("Filtered Employees:");
        filteredEmployees.forEach(System.out::println);
    }

    public static List<Employee> filterEmployees(List<Employee> employees, EmployeeFilter... filters) {
        return employees.stream()
            .filter(e -> {
                for (EmployeeFilter filter : filters) {
                    if (!filter.filter(e)) {
                        return false;
                    }
                }
                return true;
            })
            .collect(Collectors.toList());
    }
}

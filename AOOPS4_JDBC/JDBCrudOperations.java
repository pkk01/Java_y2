import java.sql.*;
import java.util.Scanner;

class Operations {
    public String url = "jdbc:postgresql://localhost:5432/crud_database";
    public String username = "postgres";
    public String password = "ADMINPK123";

    public void addStudent(int id, String fname, String lname, int age, String phno) {
        String query = "insert into student values (?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, lname);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, phno);
            preparedStatement.execute();
            System.out.println("Student added successfully");
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error adding the student" + e.getMessage());
        }
    }

    public void readAllStudent() {
        String query = "select * from student";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("First Name: " + resultSet.getString(2));
                System.out.println("last Name : " + resultSet.getString(3));
                System.out.println("Student: Age: " + resultSet.getString(4));
                System.out.println("Student Phno: " + resultSet.getInt(5));

                System.out.println("-------------------------------------------------------");

            }

        } catch (SQLException e) {
            System.out.println("failed to read: " + e.getMessage());
        }
    }

    public void updateStudentAge(int id, int age) {
        String query = "update student " +
                "set sage = ? where id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

            System.out.println("updated Successfully");

        } catch (Exception e) {
            System.out.println("Failed to update: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String query = "delete from student" +
                " where id = ?";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            System.out.println("Student deleted Successfully");
        } catch (SQLException e) {
            System.out.println("Failed to delete: " + e.getMessage());
        }
    }
}


public class JDBCrudOperations {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Update Student Age");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phone = scanner.nextLine();
                    operations.addStudent(id, firstName, lastName, age, phone);
                    break;

                case 2:
                    operations.readAllStudent();
                    break;

                case 3:
                    System.out.println("Enter student ID to update:");
                    int updateId = scanner.nextInt();
                    System.out.println("Enter new age:");
                    int newAge = scanner.nextInt();
                    operations.updateStudentAge(updateId, newAge);
                    break;

                case 4:
                    System.out.println("Enter student ID to delete:");
                    int deleteId = scanner.nextInt();
                    operations.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}




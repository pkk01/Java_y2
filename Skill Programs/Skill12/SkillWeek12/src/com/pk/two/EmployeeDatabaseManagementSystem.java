package com.pk.two;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDatabaseManagementSystem {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/employeedb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "ADMINPK123";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void addEmployee(String name, String department, double salary) {
        String query = "INSERT INTO Employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void viewEmployee(int employeeId) {
        String query = "SELECT * FROM Employees WHERE employee_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Department: %s, Salary: %.2f\n",
                        rs.getInt("employee_id"), rs.getString("name"),
                        rs.getString("department"), rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing employee: " + e.getMessage());
        }
    }

    public void updateEmployee(int employeeId, String name, String department, double salary) {
        String query = "UPDATE Employees SET name = ?, department = ?, salary = ? WHERE employee_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.setInt(4, employeeId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM Employees WHERE employee_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmployeeDatabaseManagementSystem system = new EmployeeDatabaseManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Database Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter department: ");
                    String department = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    system.addEmployee(name, department, salary);
                    break;
                case 2:
                    System.out.print("Enter employee ID to view: ");
                    int viewId = scanner.nextInt();
                    system.viewEmployee(viewId);
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new department: ");
                    String newDepartment = scanner.next();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    system.updateEmployee(updateId, newName, newDepartment, newSalary);
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

package com.pk.three;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/studentdb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "ADMINPK123";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void insertStudent(String name, int age, String grade) {
        String query = "INSERT INTO Student (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String studentInfo = String.format("ID: %d, Name: %s, Age: %d, Grade: %s",
                        rs.getInt("student_id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("grade"));
                students.add(studentInfo);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return students;
    }

    public String getStudentById(int studentId) {
        String query = "SELECT * FROM Student WHERE student_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return String.format("ID: %d, Name: %s, Age: %d, Grade: %s",
                        rs.getInt("student_id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("grade"));
            } else {
                return "Student not found.";
            }

        } catch (SQLException e) {
            return "Error retrieving student: " + e.getMessage();
        }
    }

    public void updateStudent(int studentId, String name, int age, String grade) {
        String query = "UPDATE Student SET name = ?, age = ?, grade = ? WHERE student_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.setInt(4, studentId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Student WHERE student_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, studentId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Management");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    String grade = scanner.next();
                    dao.insertStudent(name, age, grade);
                    break;
                case 2:
                    dao.getAllStudents().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.println(dao.getStudentById(studentId));
                    break;
                case 4:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.next();
                    dao.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

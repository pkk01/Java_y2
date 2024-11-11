package com.pk.one;

import java.sql.*;

public class LibraryManagementSystem {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/librarydb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "ADMINPK123";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void viewAvailableBooks() {
        String query = "SELECT * FROM Books WHERE is_available = TRUE";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.printf("ID: %d, Title: %s, Author: %s\n",
                        rs.getInt("book_id"), rs.getString("title"), rs.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkoutBook(int userId, int bookId) {
        String checkAvailability = "SELECT is_available FROM Books WHERE book_id = ?";
        String updateBook = "UPDATE Books SET is_available = FALSE WHERE book_id = ?";
        String addLoan = "INSERT INTO BookLoans (user_id, book_id) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkAvailability);
             PreparedStatement updateStmt = conn.prepareStatement(updateBook);
             PreparedStatement loanStmt = conn.prepareStatement(addLoan)) {

            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getBoolean("is_available")) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                loanStmt.setInt(1, userId);
                loanStmt.setInt(2, bookId);
                loanStmt.executeUpdate();

                System.out.println("Book checked out successfully.");
                return true;
            } else {
                System.out.println("Book is not available for checkout.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean returnBook(int userId, int bookId) {
        String checkLoan = "SELECT * FROM BookLoans WHERE user_id = ? AND book_id = ?";
        String updateBook = "UPDATE Books SET is_available = TRUE WHERE book_id = ?";
        String deleteLoan = "DELETE FROM BookLoans WHERE user_id = ? AND book_id = ?";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkLoan);
             PreparedStatement updateStmt = conn.prepareStatement(updateBook);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteLoan)) {

            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                deleteStmt.setInt(1, userId);
                deleteStmt.setInt(2, bookId);
                deleteStmt.executeUpdate();

                System.out.println("Book returned successfully.");
                return true;
            } else {
                System.out.println("No record of this book being checked out by the user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.viewAvailableBooks();
        library.checkoutBook(1, 101);
        library.returnBook(1, 101);
    }
}

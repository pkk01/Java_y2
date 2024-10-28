import java.sql.*;

public class ProductManager {

    public void addProduct(String productId, String productName, double price, int quantity) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Product (product_id, product_name, product_price, product_quantity) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, productId);
            stmt.setString(2, productName);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        }
    }

    public void sellProduct(String productId, int quantitySold) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement checkStmt = conn.prepareStatement("SELECT product_quantity FROM Product WHERE product_id = ?");
                 PreparedStatement updateStmt = conn.prepareStatement("UPDATE Product SET product_quantity = product_quantity - ? WHERE product_id = ?")) {

                checkStmt.setString(1, productId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt("product_quantity") >= quantitySold) {
                    updateStmt.setInt(1, quantitySold);
                    updateStmt.setString(2, productId);
                    updateStmt.executeUpdate();
                    conn.commit();
                }
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

    public void applyStockDiscounts() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("UPDATE Product SET product_price = product_price * 0.25 " +
                    "WHERE product_quantity < 5");
            stmt.executeUpdate("UPDATE Product SET product_price = product_price * 0.5 " +
                    "WHERE product_quantity < 10 AND product_quantity >= 5");
            stmt.executeUpdate("UPDATE Product SET product_price = product_price * 0.75 " +
                    "WHERE product_quantity < 15 AND product_quantity >= 10");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyFestiveDiscounts() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("UPDATE Product SET product_price = product_price * 0.3");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllProducts() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM product")) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No Product available");
                return;
            }

            System.out.printf("%-12s| %-14s| %-18s| %-15s%n",
                    "productID", "productName", "productQuantity", "productPrice");
            System.out.println("------------+--------------+------------------+---------------");

            while (resultSet.next()) {
                System.out.printf("%-12s| %-14s| %18d | %15.2f%n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteOutOfStockProducts() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Product WHERE product_quantity = 0")) {
            stmt.executeUpdate();
        }
    }
}

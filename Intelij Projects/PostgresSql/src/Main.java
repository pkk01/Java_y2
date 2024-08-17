import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM employee";
        String url = "jdbc:postgresql://localhost:5432/example";
        String username = "postgres";
        String password = "ADMIN123";

        try (Connection co = DriverManager.getConnection(url, username, password);
             Statement st = co.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = rs.getString(i);
                    System.out.print(columnName + ": " + columnValue + " | ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

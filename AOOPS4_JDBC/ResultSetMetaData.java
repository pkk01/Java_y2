import java.sql.*;

public class ResultSetMetaData {
    public static String url = "jdbc:postgresql://localhost:5432/crud_database";
    public static String username = "posgtres";
    public static String password = "ADMINPK123";
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        String vsql = "select * from student";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(vsql);
//        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int ccount = resultSetMetaData.getColumnCount();
        System.out.println("Total columns: " + ccount);
        System.out.println("Name" + "\t" + "Type");
        System.out.println("----" + "\t" + "----");
        for (int i = 1; i <= ccount; i++) {
            System.out.println(resultSetMetaData.getColumnName(i) + "\t" + resultSetMetaData.getColumnTypeName(i));
        }
        conn.close();
    }
}

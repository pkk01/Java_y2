package sqlConnectivity;

import java.sql.Connection;

public class ConnectSql {
    public static void main(String[] args) throws Exception {
        String sql = "select * from employee";
        String url = "jdbc:postgresql://localhost:5432/employee";
        String username = "postgres";
        String password = "ADMIN123";
        Connection co = DriverManager.getConnection(url, username, password);
        Statement st = co.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);
    }
}

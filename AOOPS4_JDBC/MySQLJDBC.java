import java.sql.*;

public class MySQLJDBC {
	public static void main (String[] args) {
		String url = "jdbc:postgresql://localhost:5432/s21";
		//String url = "jdbc:mysql://localhost:3306/s21";
		String username = "postgres";
		String password = "ADMINPK123";
		
		try {
			//Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection (url, username, password);
			System.out.println("Connected to the database");

			String query = "select * from student";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String name = resultSet.getString("sname");
				int id = resultSet.getInt("sid");
				System.out.println("id: "+ id + ", name: "+ name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
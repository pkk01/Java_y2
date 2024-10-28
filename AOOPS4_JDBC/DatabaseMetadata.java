// database meta database
import java.sql.*;

public class DatabaseMetadata {
    public static void main (String pk[]) throws Exception{
        Connection conn = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/","postgres","ADMINPK123");
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println ("Driver Name: "+dbmd.getDriverName());
        System.out.println ("Driver Version: "+dbmd.getDriverVersion());
        System.out.println ("UserName: "+dbmd.getUserName());
        System.out.println ("Database Product Name: "+dbmd.getDatabaseProductName());
        System.out.println ("Database Product Version: "+dbmd.getDatabaseProductVersion());
        conn.close();

    }
}
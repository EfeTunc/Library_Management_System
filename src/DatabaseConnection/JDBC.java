package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class JDBC {
    private static String url = "jdbc:mysql://127.0.0.1:3306/library_management";
    private static String user = "root";
    private static String password = "123456";

    public static Connection connect() throws Exception{
        return DriverManager.getConnection(url,user,password);
    }
}
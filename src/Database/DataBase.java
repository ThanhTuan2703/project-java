package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://DESKTOP-QHMC6QJ:1433;"
            +"databaseName=FootBallClub;User=sa;Password=sa";
        Connection con = DriverManager.getConnection(connectionUrl);
        System.out.println("ok");
        return con;
    }
	public static void main(String[] args) {
		try {
			openConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}